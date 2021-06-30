FROM quay.io/jfdenise/wildfly-runtime-jre11

COPY --chown=jboss:root target/server $JBOSS_HOME
RUN chmod -R ug+rwX $JBOSS_HOME
