import _root_.spark.jobserver.{SparkJobValid, SparkJobInvalid, SparkJobValidation, SparkJob}
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import com.datastax.spark.connector._
import com.typesafe.config.{Config, ConfigFactory}

import scala.util.Try


object cassandraCount extends SparkJob {
  def main(args: Array[String]) {
    val config = ConfigFactory.parseString("")
    val sc = new SparkContext()
    val results = runJob(sc, config)
  }

  override def validate(sc: SparkContext, config: Config): SparkJobValidation = {
    SparkJobValid
  }

  override def runJob(sc: SparkContext, config: Config): Any = {
    val rdd = sc.cassandraTable("system", "schema_keyspaces")
    val num_row = rdd.count()
    num_row
  }
}