name := "cassandra-count"

version := "1.0"

scalaVersion := "2.10.5"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.4.1" % "provided"

libraryDependencies += "com.datastax.spark" %% "spark-cassandra-connector" % "1.4.0"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "1.4.1" % "provided"

resolvers += "Job Server Bintray" at "https://dl.bintray.com/spark-jobserver/maven"

libraryDependencies += "spark.jobserver" %% "job-server-api" % "0.6.0" % "provided"
