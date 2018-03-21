## This script will be loaded when Rserve starts
## and before any client connect.
## Use it to pre-load packages and any data you want
## as well as define any global variables you want all
## scripts to see

## Today, pretty much everyone speaks UTF-8, it makes the life easier
Sys.setlocale(,"en_US.UTF-8")

## if you have multiple servers it's good to know which machine this is
host <- tolower(system("hostname -s", TRUE))
cat("Starting Rserve on", host,"\n")

## This is jsut a friendly way to load package and report success/failure
.libPaths( c( .libPaths(), "/home/tjc29/R/x86_64-pc-linux-gnu-library/3.1/") )
pkgs <- c("rjson", "randomForest", "stringr")

cat("Loading packages...\n")
for (pkg in pkgs) cat(pkg, ": ",require(pkg, quietly=FALSE, character.only=TRUE), "\n", sep='')

cat("Loading model and factor levels...")
ret <- readRDS("/model.rds")
fit <- ret$model # fitted random forest model for iris data
df.levels <- ret$levels # levels 

####################################################
# Model 1
####################################################
cat("Loading model 1")
model1.bundle <- readRDS("/model1-bundle.rds")
model1.fitted <- model1.bundle$fitted.model
model1.factorlevels <- model1.bundle$factor.levels
####################################################
# Model 2
####################################################
cat("Loading model 2")
model2.bundle <- readRDS("/model2-bundle.rds")
model2.fitted <- model2.bundle$fitted.model
model2.factorlevels <- model2.bundle$factor.levels
####################################################
# Model 3
####################################################
cat("Loading model 3")
model3.bundle <- readRDS("/model3-bundle.rds")
model3.fitted <- model3.bundle$fitted.model
model3.factorlevels <- model3.bundle$factor.levels
####################################################
# Model 4
####################################################
cat("Loading model 4")
model4.bundle <- readRDS("/model4-bundle.rds")
model4.fitted <- model4.bundle$fitted.model
model4.factorlevels <- model4.bundle$factor.levels
####################################################
# Model 5
####################################################
cat("Loading model 5")
model5.bundle <- readRDS("/model5-bundle.rds")
model5.fitted <- model5.bundle$fitted.model
model5.factorlevels <- model5.bundle$factor.levels
