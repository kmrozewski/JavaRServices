FROM r-base:3.4.2

RUN R -e "install.packages('Rserve', repos='http://cran.r-project.org')"
RUN R -e "install.packages('rjson')"
RUN R -e "install.packages('randomForest')"
RUN R -e "install.packages('stringr')"


COPY ./config/rserve.conf /rserve.conf
COPY ./scripts/rserve.R /rserve.R
COPY ./scripts/load-functions.R /load-functions.R
COPY ./config/passwordfile /passwordfile

COPY ./models/randomForest_model.rds /model.rds
COPY ./models/model-1-rf-bundle-20180131.rds /model1-bundle.rds
COPY ./models/model-2-rf-bundle-20180207.rds /model2-bundle.rds
COPY ./models/model-4-rf-bundle-20180222.rds /model4-bundle.rds

COPY entrypoint.sh /

RUN chmod +x /entrypoint.sh
ENTRYPOINT ["/entrypoint.sh"]

EXPOSE 6311