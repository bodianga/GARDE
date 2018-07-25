// @GENERATOR:play-routes-compiler
// @SOURCE:/home/bodianga/IdeaProjects/git/theGardener/conf/routes
// @DATE:Tue Jul 24 16:16:48 CEST 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  Application_4: controllers.Application,
  // @LINE:12
  FeatureController_5: controllers.FeatureController,
  // @LINE:14
  ProjectController_1: controllers.ProjectController,
  // @LINE:26
  HierarchyController_0: controllers.HierarchyController,
  // @LINE:32
  Assets_2: controllers.Assets,
  // @LINE:33
  ApiHelpController_3: controllers.ApiHelpController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    Application_4: controllers.Application,
    // @LINE:12
    FeatureController_5: controllers.FeatureController,
    // @LINE:14
    ProjectController_1: controllers.ProjectController,
    // @LINE:26
    HierarchyController_0: controllers.HierarchyController,
    // @LINE:32
    Assets_2: controllers.Assets,
    // @LINE:33
    ApiHelpController_3: controllers.ApiHelpController
  ) = this(errorHandler, Application_4, FeatureController_5, ProjectController_1, HierarchyController_0, Assets_2, ApiHelpController_3, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_4, FeatureController_5, ProjectController_1, HierarchyController_0, Assets_2, ApiHelpController_3, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Application.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """features/""" + "$" + """project<[^/]+>/""" + "$" + """feature<[^/]+>""", """controllers.Application.feature(project:String, feature:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/features/""" + "$" + """project<[^/]+>/""" + "$" + """feature<[^/]+>""", """controllers.FeatureController.feature(project:String, feature:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/projects""", """controllers.ProjectController.registerProject()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/projects""", """controllers.ProjectController.getAllProjects()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/projects/""" + "$" + """id<[^/]+>""", """controllers.ProjectController.getProject(id:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/projects/""" + "$" + """id<[^/]+>""", """controllers.ProjectController.updateProject(id:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/projects/""" + "$" + """id<[^/]+>""", """controllers.ProjectController.deleteProject(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/projects/""" + "$" + """id<[^/]+>/synchronize""", """controllers.ProjectController.synchronizeProject(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/projects/""" + "$" + """id<[^/]+>/hierarchy""", """controllers.ProjectController.getLinkProjectToHierarchy(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/projects/""" + "$" + """id<[^/]+>/hierarchy/""" + "$" + """hierarchyId<[^/]+>""", """controllers.ProjectController.linkProjectToHierarchy(id:String, hierarchyId:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/projects/""" + "$" + """id<[^/]+>/hierarchy/""" + "$" + """hierarchyId<[^/]+>""", """controllers.ProjectController.deleteLinkProjectToHierarchy(id:String, hierarchyId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/hierarchy""", """controllers.HierarchyController.addHierarchy()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/hierarchy""", """controllers.HierarchyController.getAllHierarchies()"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/hierarchy/""" + "$" + """id<[^/]+>""", """controllers.HierarchyController.updateHierarchy(id:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/hierarchy/""" + "$" + """id<[^/]+>""", """controllers.HierarchyController.deleteHierarchy(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/docs/""", """controllers.Assets.at(path:String = "/public/swagger-ui", file:String = "index.html")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/docs/swagger.json""", """controllers.ApiHelpController.getResources"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/docs/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public/swagger-ui", file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_Application_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_index0_invoker = createInvoker(
    Application_4.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ Views""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Application_feature1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("features/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("feature", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_feature1_invoker = createInvoker(
    Application_4.feature(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "feature",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """features/""" + "$" + """project<[^/]+>/""" + "$" + """feature<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_FeatureController_feature2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/features/"), DynamicPart("project", """[^/]+""",true), StaticPart("/"), DynamicPart("feature", """[^/]+""",true)))
  )
  private[this] lazy val controllers_FeatureController_feature2_invoker = createInvoker(
    FeatureController_5.feature(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FeatureController",
      "feature",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """api/features/""" + "$" + """project<[^/]+>/""" + "$" + """feature<[^/]+>""",
      """ API""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_ProjectController_registerProject3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/projects")))
  )
  private[this] lazy val controllers_ProjectController_registerProject3_invoker = createInvoker(
    ProjectController_1.registerProject(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProjectController",
      "registerProject",
      Nil,
      "POST",
      this.prefix + """api/projects""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_ProjectController_getAllProjects4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/projects")))
  )
  private[this] lazy val controllers_ProjectController_getAllProjects4_invoker = createInvoker(
    ProjectController_1.getAllProjects(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProjectController",
      "getAllProjects",
      Nil,
      "GET",
      this.prefix + """api/projects""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_ProjectController_getProject5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/projects/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProjectController_getProject5_invoker = createInvoker(
    ProjectController_1.getProject(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProjectController",
      "getProject",
      Seq(classOf[String]),
      "GET",
      this.prefix + """api/projects/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_ProjectController_updateProject6_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/projects/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProjectController_updateProject6_invoker = createInvoker(
    ProjectController_1.updateProject(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProjectController",
      "updateProject",
      Seq(classOf[String]),
      "PUT",
      this.prefix + """api/projects/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_ProjectController_deleteProject7_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/projects/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProjectController_deleteProject7_invoker = createInvoker(
    ProjectController_1.deleteProject(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProjectController",
      "deleteProject",
      Seq(classOf[String]),
      "DELETE",
      this.prefix + """api/projects/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_ProjectController_synchronizeProject8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/projects/"), DynamicPart("id", """[^/]+""",true), StaticPart("/synchronize")))
  )
  private[this] lazy val controllers_ProjectController_synchronizeProject8_invoker = createInvoker(
    ProjectController_1.synchronizeProject(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProjectController",
      "synchronizeProject",
      Seq(classOf[String]),
      "POST",
      this.prefix + """api/projects/""" + "$" + """id<[^/]+>/synchronize""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_ProjectController_getLinkProjectToHierarchy9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/projects/"), DynamicPart("id", """[^/]+""",true), StaticPart("/hierarchy")))
  )
  private[this] lazy val controllers_ProjectController_getLinkProjectToHierarchy9_invoker = createInvoker(
    ProjectController_1.getLinkProjectToHierarchy(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProjectController",
      "getLinkProjectToHierarchy",
      Seq(classOf[String]),
      "GET",
      this.prefix + """api/projects/""" + "$" + """id<[^/]+>/hierarchy""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_ProjectController_linkProjectToHierarchy10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/projects/"), DynamicPart("id", """[^/]+""",true), StaticPart("/hierarchy/"), DynamicPart("hierarchyId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProjectController_linkProjectToHierarchy10_invoker = createInvoker(
    ProjectController_1.linkProjectToHierarchy(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProjectController",
      "linkProjectToHierarchy",
      Seq(classOf[String], classOf[String]),
      "POST",
      this.prefix + """api/projects/""" + "$" + """id<[^/]+>/hierarchy/""" + "$" + """hierarchyId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_ProjectController_deleteLinkProjectToHierarchy11_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/projects/"), DynamicPart("id", """[^/]+""",true), StaticPart("/hierarchy/"), DynamicPart("hierarchyId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProjectController_deleteLinkProjectToHierarchy11_invoker = createInvoker(
    ProjectController_1.deleteLinkProjectToHierarchy(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProjectController",
      "deleteLinkProjectToHierarchy",
      Seq(classOf[String], classOf[String]),
      "DELETE",
      this.prefix + """api/projects/""" + "$" + """id<[^/]+>/hierarchy/""" + "$" + """hierarchyId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_HierarchyController_addHierarchy12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/hierarchy")))
  )
  private[this] lazy val controllers_HierarchyController_addHierarchy12_invoker = createInvoker(
    HierarchyController_0.addHierarchy(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HierarchyController",
      "addHierarchy",
      Nil,
      "POST",
      this.prefix + """api/hierarchy""",
      """ HIERARCHY""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_HierarchyController_getAllHierarchies13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/hierarchy")))
  )
  private[this] lazy val controllers_HierarchyController_getAllHierarchies13_invoker = createInvoker(
    HierarchyController_0.getAllHierarchies(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HierarchyController",
      "getAllHierarchies",
      Nil,
      "GET",
      this.prefix + """api/hierarchy""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_HierarchyController_updateHierarchy14_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/hierarchy/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HierarchyController_updateHierarchy14_invoker = createInvoker(
    HierarchyController_0.updateHierarchy(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HierarchyController",
      "updateHierarchy",
      Seq(classOf[String]),
      "PUT",
      this.prefix + """api/hierarchy/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_HierarchyController_deleteHierarchy15_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/hierarchy/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HierarchyController_deleteHierarchy15_invoker = createInvoker(
    HierarchyController_0.deleteHierarchy(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HierarchyController",
      "deleteHierarchy",
      Seq(classOf[String]),
      "DELETE",
      this.prefix + """api/hierarchy/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:32
  private[this] lazy val controllers_Assets_at16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/docs/")))
  )
  private[this] lazy val controllers_Assets_at16_invoker = createInvoker(
    Assets_2.at(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """api/docs/""",
      """ Swagger API""",
      Seq()
    )
  )

  // @LINE:33
  private[this] lazy val controllers_ApiHelpController_getResources17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/docs/swagger.json")))
  )
  private[this] lazy val controllers_ApiHelpController_getResources17_invoker = createInvoker(
    ApiHelpController_3.getResources,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiHelpController",
      "getResources",
      Nil,
      "GET",
      this.prefix + """api/docs/swagger.json""",
      """""",
      Seq()
    )
  )

  // @LINE:34
  private[this] lazy val controllers_Assets_at18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/docs/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at18_invoker = createInvoker(
    Assets_2.at(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """api/docs/""" + "$" + """file<.+>""",
      """""",
      Seq()
    )
  )

  // @LINE:37
  private[this] lazy val controllers_Assets_versioned19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned19_invoker = createInvoker(
    Assets_2.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_Application_index0_route(params@_) =>
      call { 
        controllers_Application_index0_invoker.call(Application_4.index())
      }
  
    // @LINE:9
    case controllers_Application_feature1_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("feature", None)) { (project, feature) =>
        controllers_Application_feature1_invoker.call(Application_4.feature(project, feature))
      }
  
    // @LINE:12
    case controllers_FeatureController_feature2_route(params@_) =>
      call(params.fromPath[String]("project", None), params.fromPath[String]("feature", None)) { (project, feature) =>
        controllers_FeatureController_feature2_invoker.call(FeatureController_5.feature(project, feature))
      }
  
    // @LINE:14
    case controllers_ProjectController_registerProject3_route(params@_) =>
      call { 
        controllers_ProjectController_registerProject3_invoker.call(ProjectController_1.registerProject())
      }
  
    // @LINE:15
    case controllers_ProjectController_getAllProjects4_route(params@_) =>
      call { 
        controllers_ProjectController_getAllProjects4_invoker.call(ProjectController_1.getAllProjects())
      }
  
    // @LINE:16
    case controllers_ProjectController_getProject5_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ProjectController_getProject5_invoker.call(ProjectController_1.getProject(id))
      }
  
    // @LINE:17
    case controllers_ProjectController_updateProject6_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ProjectController_updateProject6_invoker.call(ProjectController_1.updateProject(id))
      }
  
    // @LINE:18
    case controllers_ProjectController_deleteProject7_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ProjectController_deleteProject7_invoker.call(ProjectController_1.deleteProject(id))
      }
  
    // @LINE:19
    case controllers_ProjectController_synchronizeProject8_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ProjectController_synchronizeProject8_invoker.call(ProjectController_1.synchronizeProject(id))
      }
  
    // @LINE:20
    case controllers_ProjectController_getLinkProjectToHierarchy9_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ProjectController_getLinkProjectToHierarchy9_invoker.call(ProjectController_1.getLinkProjectToHierarchy(id))
      }
  
    // @LINE:21
    case controllers_ProjectController_linkProjectToHierarchy10_route(params@_) =>
      call(params.fromPath[String]("id", None), params.fromPath[String]("hierarchyId", None)) { (id, hierarchyId) =>
        controllers_ProjectController_linkProjectToHierarchy10_invoker.call(ProjectController_1.linkProjectToHierarchy(id, hierarchyId))
      }
  
    // @LINE:22
    case controllers_ProjectController_deleteLinkProjectToHierarchy11_route(params@_) =>
      call(params.fromPath[String]("id", None), params.fromPath[String]("hierarchyId", None)) { (id, hierarchyId) =>
        controllers_ProjectController_deleteLinkProjectToHierarchy11_invoker.call(ProjectController_1.deleteLinkProjectToHierarchy(id, hierarchyId))
      }
  
    // @LINE:26
    case controllers_HierarchyController_addHierarchy12_route(params@_) =>
      call { 
        controllers_HierarchyController_addHierarchy12_invoker.call(HierarchyController_0.addHierarchy())
      }
  
    // @LINE:27
    case controllers_HierarchyController_getAllHierarchies13_route(params@_) =>
      call { 
        controllers_HierarchyController_getAllHierarchies13_invoker.call(HierarchyController_0.getAllHierarchies())
      }
  
    // @LINE:28
    case controllers_HierarchyController_updateHierarchy14_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_HierarchyController_updateHierarchy14_invoker.call(HierarchyController_0.updateHierarchy(id))
      }
  
    // @LINE:29
    case controllers_HierarchyController_deleteHierarchy15_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_HierarchyController_deleteHierarchy15_invoker.call(HierarchyController_0.deleteHierarchy(id))
      }
  
    // @LINE:32
    case controllers_Assets_at16_route(params@_) =>
      call(Param[String]("path", Right("/public/swagger-ui")), Param[String]("file", Right("index.html"))) { (path, file) =>
        controllers_Assets_at16_invoker.call(Assets_2.at(path, file))
      }
  
    // @LINE:33
    case controllers_ApiHelpController_getResources17_route(params@_) =>
      call { 
        controllers_ApiHelpController_getResources17_invoker.call(ApiHelpController_3.getResources)
      }
  
    // @LINE:34
    case controllers_Assets_at18_route(params@_) =>
      call(Param[String]("path", Right("/public/swagger-ui")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at18_invoker.call(Assets_2.at(path, file))
      }
  
    // @LINE:37
    case controllers_Assets_versioned19_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned19_invoker.call(Assets_2.versioned(path, file))
      }
  }
}
