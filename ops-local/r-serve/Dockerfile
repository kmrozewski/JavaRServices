FROM r-base:3.4.2

RUN R -e "install.packages('Rserve', repos='http://cran.r-project.org')"
RUN R -e "install.packages('RJSONIO')"
RUN R -e "install.packages('randomForest')"
RUN R -e "install.packages('stringr')"


COPY ./config/rserve.conf /rserve.conf
COPY ./scripts/rserve.R /rserve.R
COPY ./scripts/load-functions.R /load-functions.R
COPY ./config/passwordfile /passwordfile
COPY ./randomForest_model.rds /model.rds
COPY entrypoint.sh /

RUN chmod +x /entrypoint.sh
ENTRYPOINT ["/entrypoint.sh"]

EXPOSE 6311