import _root_.spark.jobserver.{SparkJobValid, SparkJobInvalid, SparkJobValidation, SparkJob}
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import com.datastax.spark.connector._
import com.typesafe.config.{Config, ConfigFactory}

import scala.util.Try

// all Jobserver jobs must implement the SparkJob trait
object cassandraCount extends SparkJob {

  //validate method can be used to check that required information is supplied in the config, context is of the right type, etc
  //to keep things simple, we will just return valid
  override def validate(sc: SparkContext, config: Config): SparkJobValidation = {
    SparkJobValid
  }

  //runJob is where the actual work of the job goes
  override def runJob(sc: SparkContext, config: Config): Any = {
    val rdd = sc.cassandraTable("system", "schema_keyspaces") //create an rdd from the system.schema_keyspaces table
    val num_row = rdd.count() // count the number of rows in the rdd
    num_row // return the result
  }
}