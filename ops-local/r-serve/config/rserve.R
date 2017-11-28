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
## You will definiteily need FastRWeb, others are optional
.libPaths( c( .libPaths(), "/home/tjc29/R/x86_64-pc-linux-gnu-library/3.1/") )
pkgs <- c("rjson", "randomForest")

cat("Loading packages...\n")
for (pkg in pkgs) cat(pkg, ": ",require(pkg, quietly=FALSE, character.only=TRUE), "\n", sep='')

cat("Loading model and factor levels...")
ret <- readRDS("/model.rds")
fit <- ret$model # fitted random forest model for iris data
df.levels <- ret$levels # levels 