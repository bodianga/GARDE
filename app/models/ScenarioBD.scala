package models

case class ScenarioBD(id : Int, description : String, scenarioType : String, workflowStep : String, caseType: String, abstractionLevel : String, stepsAsJson :Option[String] = None, keyword : Option[String] = None, name : Option[String] = None, featureId : Int )