getPrediction <- function(sepalLength, sepalWidth, petalLength, petalWidth) {
    input.data <- data.frame(sepalLength = sepalLength,
    sepalWidth = sepalWidth,
    petalLength = factor(petalLength, levels = df.levels$petalLength),
    petalWidth = factor(petalWidth, levels = df.levels$petalWidth))

    fit.predict <- predict(fit, newdata = input.data, type = "prob")

    response <- list(probability = as.null(),
    label = as.character(colnames(fit.predict)[1]),
    inputData = input.data,
    message = ifelse(is.na(fit.predict[1]), "Fail - NA value", "Success"),
    timestamp = as.character(Sys.time()))

    if (!is.na(fit.predict[1])) {
        response$probability <- as.numeric(fit.predict[1])
    }

    return(toJSON(response))
}

getPrediction(frm$sepalLength, frm$sepalWidth, frm$petalLength, frm$petalWidth)
