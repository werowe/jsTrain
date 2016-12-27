import org.apache.spark.ml.regression.LinearRegression

val training = spark.read.format("libsvm").load("/home/walker/Downloads/data.svm")

val lr = new LinearRegression().setMaxIter(10).setRegParam(0.3).setElasticNetParam(0.8)


val lrModel = lr.fit(training)


println(s"Coefficients: ${lrModel.coefficients} Intercept: ${lrModel.intercept}")


val trainingSummary = lrModel.summary
println(s"numIterations: ${trainingSummary.totalIterations}")
println(s"objectiveHistory: ${trainingSummary.objectiveHistory.toList}")
trainingSummary.residuals.show()
println(s"RMSE: ${trainingSummary.rootMeanSquaredError}")
println(s"r2: ${trainingSummary.r2}")

