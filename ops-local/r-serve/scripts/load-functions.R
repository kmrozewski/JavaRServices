# Helper function to return model prediction results
getPredictResponse <- function(fit.predict) {
	list(probability = as.numeric(fit.predict[, 1]),
			 label = as.character(colnames(fit.predict))[1],
			 message = ifelse(is.na(fit.predict[, 1]), "Fail - NA value", "Success"),
			 timestamp = as.character(rep(Sys.time(), length(fit.predict[, 1]))))
}


# Helper function to merge input data and model prediction results
getResponse <- function(input.data, fit.predict) {
	inputDataResults <- toJSON(input.data, collapse = "", asIs = TRUE) %>% 
		paste0('"inputData": ', .)
	
	predictResults <- toJSON(getPredictResponse(fit.predict), collapse = "") %>% 
		str_replace("^\\[ ", "") %>% 
		str_replace(" \\]$", "") %>%
		paste0('"predictResults": [', ., "]")
	
	paste0("{", inputDataResults, ",", predictResults, "}")
}

# Returns random forest predictions for data frame with structure
# input structure (R DataFrame)
# inputData(sepalLength: Double, sepalWidth: Double, petalLength: String, petalWidth: String)
# output structure (JSON)
# {
#		inputData: {
#			sepalLength: Double array,
#			sepalLength: Double array,
#			sepalLength: String array,
#			sepalLength: String array
# 	},
# 	predictResults: [
#	{
#			probability: Double
#			label: String
#			message: String
#			probability: String
# 	}]
# }
getAllPredictions <- function(input.data) {
	input.data$petalLength <- factor(input.data$petalLength, levels = df.levels$petalLength)
	input.data$petalWidth <- factor(input.data$petalWidth, levels = df.levels$petalWidth)
	
	fit.predict <- predict(fit, newdata = input.data, type = "prob")
	
	getResponse(input.data, fit.predict)
}

# Similar to the function getAllPredictions. Takes only one value as input
getPrediction <- function(sepalLength, sepalWidth, petalLength, petalWidth) {
	input.data <- data.frame(sepalLength = sepalLength, 
													 sepalWidth = sepalWidth, 
													 petalLength = factor(petalLength, levels = df.levels$petalLength), 
													 petalWidth = factor(petalWidth, levels = df.levels$petalWidth))
	
	fit.predict <- predict(fit, newdata = input.data, type = "prob")
	
	getResponse(input.data, fit.predict)
}