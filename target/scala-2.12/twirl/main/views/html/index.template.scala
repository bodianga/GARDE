
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("Welcome to Play")/*3.25*/ {_display_(Seq[Any](format.raw/*3.27*/("""
    
    """),format.raw/*5.5*/("""<p>"""),_display_(/*5.9*/message),format.raw/*5.16*/("""</p>


    <a href="features/suggestionsWS/provide_book_suggestions.feature">Feature display example</a> <br/>
    <a href="api/features/suggestionsWS/provide_book_suggestions.feature">Feature api example</a>
    
""")))}))
      }
    }
  }

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 24 16:16:48 CEST 2018
                  SOURCE: /home/bodianga/IdeaProjects/git/theGardener/app/views/index.scala.html
                  HASH: 266af549ad4fea7a6ef49468bb4d8793548bcee2
                  MATRIX: 729->1|840->19|867->21|898->44|937->46|973->56|1002->60|1029->67
                  LINES: 21->1|26->2|27->3|27->3|27->3|29->5|29->5|29->5
                  -- GENERATED --
              */
          