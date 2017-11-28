FROM r-base:3.4.2

RUN R -e "install.packages('Rserve', repos='http://cran.r-project.org')"
RUN R -e "install.packages('rjson')"
RUN R -e "install.packages('randomForest')"


COPY ./config/rserve.conf /rserve.conf
COPY ./config/rserve.R /rserve.R
COPY ./config/passwordfile /passwordfile
COPY ./randomForest_model.rds /model.rds
COPY entrypoint.sh /

RUN chmod +x /entrypoint.sh
ENTRYPOINT ["/entrypoint.sh"]

EXPOSE 6311