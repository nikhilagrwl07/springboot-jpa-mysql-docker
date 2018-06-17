//package com.fitness.beans;
//
//import com.fitness.interceptors.RequestInterceptor;
//import lombok.extern.log4j.Log4j;
//import lombok.extern.log4j.Log4j2;
//import org.influxdb.InfluxDB;
//import org.influxdb.InfluxDBFactory;
//import org.influxdb.request.Point;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.actuate.autoconfigure.ExportMetricWriter;
//import org.springframework.boot.actuate.endpoint.MetricsEndpoint;
//import org.springframework.boot.actuate.endpoint.MetricsEndpointMetricReader;
//import org.springframework.boot.actuate.metrics.Metric;
//import org.springframework.boot.actuate.metrics.reader.MetricReader;
//import org.springframework.boot.actuate.metrics.writer.GaugeWriter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.concurrent.TimeUnit;
//
//
//@Configuration
//public class MetricsEndpointBean {
//    private static final Logger logger = LoggerFactory.getLogger(MetricsEndpointBean.class);
//
//    @Bean
//    public MetricsEndpointMetricReader metricsEndpointMetricReader(MetricsEndpoint metricReader){
//        return new MetricsEndpointMetricReader(metricReader);
//    }
//
//    @Bean
//    @ExportMetricWriter
//    GaugeWriter influxMetricsWriter() {
//        InfluxDB influxDB = InfluxDBFactory.connect("http://localhost:8086", "root", "root");
//        String dbName = "wadus";
//        influxDB.setDatabase(dbName);
//        influxDB.setRetentionPolicy("autogen");
//        influxDB.enableBatch(10, 1000, TimeUnit.MILLISECONDS);
//
//        return new GaugeWriter() {
//            @Override
//            public void set(Metric<?> value) {
//                Point point = Point.measurement(value.getName())
//                                   .time(value.getTimestamp().getTime(), TimeUnit.MILLISECONDS)
//                                   .addField("value", value.getValue()).build();
//                influxDB.write(point);
//                logger.info("write(" + value.getName() + "): " + value.getValue());
//            }
//        };
//    }
//}
