package org.apache.spark.ml

import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.sql.{SQLContext, DataFrame}

object TestBase {
  private val conf = new SparkConf()
    .setMaster("local[2]")
	.setAppName("test")
	.set("spark.eventLog.enabled", "true")
	.set("spark.eventLog.dir", "log")
  val sc = new SparkContext(conf)
  val sqlContext = SQLContext.getOrCreate(sc)
  val db = new TestDb(TestConfig.databaseName, TestConfig.modelsCollection)
}