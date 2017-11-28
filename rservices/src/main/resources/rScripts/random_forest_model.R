getPrediction <- function(sepalLength, sepalWidth, petalLength, petalWidth) {
    input.data <- data.frame(sepalLength = sepalLength,
    sepalWidth = sepalWidth,
    petalLength = factor(petalLength, levels = df.levels$petalLength),
    petalWidth = factor(petalWidth, levels = df.levels$petalWidth))

    fit.predict <- predict(fit, newdata = input.data, type = "prob")

    response <- list(probability = as.numeric(fit.predict[1]),
    label = as.character(colnames(fit.predict)[1]),
    inputData = input.data,
    message = "Success",
    timestamp = as.character(Sys.time()))

    return(toJSON(response))
}

getPrediction(frm$sepalLength, frm$sepalWidth, frm$petalLength, frm$petalWidth)
