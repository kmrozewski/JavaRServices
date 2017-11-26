FROM r-base:3.4.2

RUN R -e "install.packages('Rserve', repos='http://cran.r-project.org')"
RUN R -e "install.packages('rjson')"


COPY ./config/rserve.conf /rserve.conf
COPY entrypoint.sh /

RUN chmod +x /entrypoint.sh
ENTRYPOINT ["/entrypoint.sh"]

EXPOSE 6311