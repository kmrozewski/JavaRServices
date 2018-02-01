


# Helper function to return model prediction results
getPredictResponse <- function(fit.prediction) {
	list(probability = as.numeric(fit.prediction[, 1]),
			 label = as.character(colnames(fit.prediction))[1],
			 message = ifelse(is.na(fit.prediction[, 1]), "Fail - NA value", "Success"),
			 timestamp = as.character(rep(Sys.time(), length(fit.prediction[, 1]))))
}


# Helper function to merge input data and model prediction results
getResponse <- function(input.data, fit.prediction) {
	inputDataResults <- toJSON(input.data, collapse = "", asIs = TRUE) %>% 
		paste0('"inputData": ', .)
	
	predictResults <- toJSON(getPredictResponse(fit.prediction), collapse = "") %>%
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
	
	fit.prediction <- prediction(fit, newdata = input.data, type = "prob")
	
	getResponse(input.data, fit.prediction)
}

# Similar to the function getAllPredictions. Takes only one value as input
getPrediction <- function(sepalLength, sepalWidth, petalLength, petalWidth) {
	input.data <- data.frame(sepalLength = sepalLength, 
													 sepalWidth = sepalWidth, 
													 petalLength = factor(petalLength, levels = df.levels$petalLength), 
													 petalWidth = factor(petalWidth, levels = df.levels$petalWidth))
	
	fit.prediction <- prediction(fit, newdata = input.data, type = "prob")
	
	getResponse(input.data, fit.prediction)
}

getModelPrediction <- function(input.data, fitted.model, input.factor.levels) {
	# Select only the first value
	frm <- input.data[1, ]
	
	# Change character columns to factors
	frm[sapply(frm, is.character)] <- lapply(names(frm[sapply(frm, is.character)]), 
																					 function(x, factor.levels) factor(frm[[x]], levels = factor.levels[[x]]),
																					 factor.levels = input.factor.levels)
	
	# Run predict
	model.pred <- predict(object = fitted.model, newdata = frm, type = "prob")
	
	# Prepare output
	model.response <- lapply(seq_along(model.pred), 
													 function(index, keys, values) list(label = keys[index], probability = values[index]),
													 keys = colnames(model.pred),
													 values = as.numeric(model.pred))
	
	toJSON(list(inputData = frm, prediction = model.response))
}
