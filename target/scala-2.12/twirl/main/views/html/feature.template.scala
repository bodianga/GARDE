
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object feature extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Feature,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(project: String, feature: Feature):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("Feature")/*3.17*/ {_display_(Seq[Any](format.raw/*3.19*/("""
    """),format.raw/*4.5*/("""<div id=""""),_display_(/*4.15*/{feature.id.replace("/", "_").replace(".", "_")}),format.raw/*4.63*/("""">
        Project: """),_display_(/*5.19*/project),format.raw/*5.26*/("""<br/>
        Branch: """),_display_(/*6.18*/feature/*6.25*/.branch),format.raw/*6.32*/("""<br/>

        """),_display_(/*8.10*/feature/*8.17*/.tags.mkString(" ")),format.raw/*8.36*/("""<br/>
        <strong>"""),_display_(/*9.18*/feature/*9.25*/.keyword),format.raw/*9.33*/("""</strong>: """),_display_(/*9.45*/feature/*9.52*/.name),format.raw/*9.57*/("""<br/>
        """),_display_(/*10.10*/Html(feature.description.replace("\n", "<br/>"))),format.raw/*10.58*/("""<br/>
        <br/>

        """),_display_(/*13.10*/for(scenario <- feature.scenarios) yield /*13.44*/ {_display_(Seq[Any](format.raw/*13.46*/("""
            """),format.raw/*14.13*/("""<div id="Scenario_"""),_display_(/*14.32*/scenario/*14.40*/.id),format.raw/*14.43*/("""">
                """),_display_(/*15.18*/{
                    scenario match {
                        case _: Background =>
                        case s: Scenario => s"Abstraction level: ${s.abstractionLevel}, case: ${s.caseType}, step: ${s.workflowStep}"
                        case s: ScenarioOutline => s"Abstraction level: ${s.abstractionLevel}, case: ${s.caseType}, step: ${s.workflowStep}"
                    }
                }),format.raw/*21.18*/(""" """),format.raw/*21.19*/("""<br/>
            <strong>"""),_display_(/*22.22*/scenario/*22.30*/.keyword),format.raw/*22.38*/(""":</strong>
                """),_display_(/*23.18*/scenario/*23.26*/.name),format.raw/*23.31*/(""" """),format.raw/*23.32*/("""<br/>
                """),_display_(/*24.18*/Html(scenario.description.replace("\n", "<br/>"))),format.raw/*24.67*/(""" """),format.raw/*24.68*/("""<br/>

                """),_display_(/*26.18*/for(step <- scenario.steps) yield /*26.45*/ {_display_(Seq[Any](format.raw/*26.47*/("""
                    """),format.raw/*27.21*/("""<div id="Step_"""),_display_(/*27.36*/step/*27.40*/.id),format.raw/*27.43*/("""">
                        <strong>"""),_display_(/*28.34*/step/*28.38*/.keyword),format.raw/*28.46*/(""":</strong>
                        """),_display_(/*29.26*/step/*29.30*/.text),format.raw/*29.35*/("""
                        """),_display_(/*30.26*/if(step.argument.nonEmpty)/*30.52*/ {_display_(Seq[Any](format.raw/*30.54*/("""
                            """),format.raw/*31.29*/("""<table>
                            """),_display_(/*32.30*/for(line <- step.argument) yield /*32.56*/ {_display_(Seq[Any](format.raw/*32.58*/("""
                                """),format.raw/*33.33*/("""<tr>
                                """),_display_(/*34.34*/for(raw <- line) yield /*34.50*/ {_display_(Seq[Any](format.raw/*34.52*/("""
                                    """),format.raw/*35.37*/("""<td>"""),_display_(/*35.42*/raw),format.raw/*35.45*/("""</td>
                                """)))}),format.raw/*36.34*/("""
                                """),format.raw/*37.33*/("""</tr>
                            """)))}),format.raw/*38.30*/("""
                            """),format.raw/*39.29*/("""</table>
                        """)))}),format.raw/*40.26*/("""
                    """),format.raw/*41.21*/("""</div>
                """)))}),format.raw/*42.18*/("""

                """),_display_(/*44.18*/if(scenario.isInstanceOf[ScenarioOutline])/*44.60*/ {_display_(Seq[Any](format.raw/*44.62*/("""
                    """),_display_(/*45.22*/defining(scenario.asInstanceOf[ScenarioOutline].examples)/*45.79*/ { examples =>_display_(Seq[Any](format.raw/*45.93*/("""
                        """),_display_(/*46.26*/for(example <- examples) yield /*46.50*/ {_display_(Seq[Any](format.raw/*46.52*/("""
                            """),format.raw/*47.29*/("""<div id="Example_"""),_display_(/*47.47*/example/*47.54*/.id),format.raw/*47.57*/("""">
                                """),_display_(/*48.34*/example/*48.41*/.tags.mkString(" ")),format.raw/*48.60*/(""" """),format.raw/*48.61*/("""<br/>
                            <strong>"""),_display_(/*49.38*/example/*49.45*/.keyword),format.raw/*49.53*/(""":</strong>
                                """),_display_(/*50.34*/Html(example.description.replace("\n", "<br/>"))),format.raw/*50.82*/(""" """),format.raw/*50.83*/("""<br/>
                            <table>
                                <tr>
                                """),_display_(/*53.34*/for(raw <- example.tableHeader) yield /*53.65*/ {_display_(Seq[Any](format.raw/*53.67*/("""
                                    """),format.raw/*54.37*/("""<th>"""),_display_(/*54.42*/raw),format.raw/*54.45*/("""</th>
                                """)))}),format.raw/*55.34*/("""
                                """),format.raw/*56.33*/("""</tr>

                                """),_display_(/*58.34*/for(line <- example.tableBody) yield /*58.64*/ {_display_(Seq[Any](format.raw/*58.66*/("""
                                    """),format.raw/*59.37*/("""<tr>
                                    """),_display_(/*60.38*/for(raw <- line) yield /*60.54*/ {_display_(Seq[Any](format.raw/*60.56*/("""
                                        """),format.raw/*61.41*/("""<td>"""),_display_(/*61.46*/raw),format.raw/*61.49*/("""</td>
                                    """)))}),format.raw/*62.38*/("""
                                    """),format.raw/*63.37*/("""</tr>
                                """)))}),format.raw/*64.34*/("""
                            """),format.raw/*65.29*/("""</table>

                            </div>
                        """)))}),format.raw/*68.26*/("""
                    """)))}),format.raw/*69.22*/("""
                """)))}),format.raw/*70.18*/("""

            """),format.raw/*72.13*/("""</div>
            <br/>
        """)))}),format.raw/*74.10*/("""
    """),format.raw/*75.5*/("""</div>
""")))}))
      }
    }
  }

  def render(project:String,feature:Feature): play.twirl.api.HtmlFormat.Appendable = apply(project,feature)

  def f:((String,Feature) => play.twirl.api.HtmlFormat.Appendable) = (project,feature) => apply(project,feature)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 24 16:16:48 CEST 2018
                  SOURCE: /home/bodianga/IdeaProjects/git/theGardener/app/views/feature.scala.html
                  HASH: b970cb4a801965db900981c416d20db2090af7f5
                  MATRIX: 739->1|868->37|895->39|918->54|957->56|988->61|1024->71|1092->119|1139->140|1166->147|1215->170|1230->177|1257->184|1299->200|1314->207|1353->226|1402->249|1417->256|1445->264|1483->276|1498->283|1523->288|1565->303|1634->351|1691->381|1741->415|1781->417|1822->430|1868->449|1885->457|1909->460|1956->480|2376->879|2405->880|2459->907|2476->915|2505->923|2560->951|2577->959|2603->964|2632->965|2682->988|2752->1037|2781->1038|2832->1062|2875->1089|2915->1091|2964->1112|3006->1127|3019->1131|3043->1134|3106->1170|3119->1174|3148->1182|3211->1218|3224->1222|3250->1227|3303->1253|3338->1279|3378->1281|3435->1310|3499->1347|3541->1373|3581->1375|3642->1408|3707->1446|3739->1462|3779->1464|3844->1501|3876->1506|3900->1509|3970->1548|4031->1581|4097->1616|4154->1645|4219->1679|4268->1700|4323->1724|4369->1743|4420->1785|4460->1787|4509->1809|4575->1866|4627->1880|4680->1906|4720->1930|4760->1932|4817->1961|4862->1979|4878->1986|4902->1989|4965->2025|4981->2032|5021->2051|5050->2052|5120->2095|5136->2102|5165->2110|5236->2154|5305->2202|5334->2203|5473->2315|5520->2346|5560->2348|5625->2385|5657->2390|5681->2393|5751->2432|5812->2465|5879->2505|5925->2535|5965->2537|6030->2574|6099->2616|6131->2632|6171->2634|6240->2675|6272->2680|6296->2683|6370->2726|6435->2763|6505->2802|6562->2831|6663->2901|6716->2923|6765->2941|6807->2955|6872->2989|6904->2994
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|28->4|28->4|29->5|29->5|30->6|30->6|30->6|32->8|32->8|32->8|33->9|33->9|33->9|33->9|33->9|33->9|34->10|34->10|37->13|37->13|37->13|38->14|38->14|38->14|38->14|39->15|45->21|45->21|46->22|46->22|46->22|47->23|47->23|47->23|47->23|48->24|48->24|48->24|50->26|50->26|50->26|51->27|51->27|51->27|51->27|52->28|52->28|52->28|53->29|53->29|53->29|54->30|54->30|54->30|55->31|56->32|56->32|56->32|57->33|58->34|58->34|58->34|59->35|59->35|59->35|60->36|61->37|62->38|63->39|64->40|65->41|66->42|68->44|68->44|68->44|69->45|69->45|69->45|70->46|70->46|70->46|71->47|71->47|71->47|71->47|72->48|72->48|72->48|72->48|73->49|73->49|73->49|74->50|74->50|74->50|77->53|77->53|77->53|78->54|78->54|78->54|79->55|80->56|82->58|82->58|82->58|83->59|84->60|84->60|84->60|85->61|85->61|85->61|86->62|87->63|88->64|89->65|92->68|93->69|94->70|96->72|98->74|99->75
                  -- GENERATED --
              */
          