name := "cassandra-count"

version := "1.0"

scalaVersion := "2.10.5"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.6.0" % "provided"

libraryDependencies += "com.datastax.spark" %% "spark-cassandra-connector" % "1.6.0-M1"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "1.6.0" % "provided"

resolvers += "Job Server Bintray" at "https://dl.bintray.com/spark-jobserver/maven"

libraryDependencies += "spark.jobserver" %% "job-server-api" % "0.6.0" % "provided"

assemblyMergeStrategy in assembly <<= (assemblyMergeStrategy in assembly) {
(old) => {
case PathList("META-INF", "io.netty.versions.properties") => MergeStrategy.last
case x => old(x)
}
}
