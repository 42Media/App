import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_ftmedia_plugins_ftLibrary_musicAssetedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/musicAsset/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('set','g',4,['var':("entityName"),'value':(message(code: 'musicAsset.label', default: 'MusicAsset'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',5,['code':("default.edit.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('message','g',9,['code':("default.edit.label"),'args':([entityName])],-1)
printHtmlPart(4)
if(true && (flash.message)) {
printHtmlPart(5)
expressionOut.print(flash.message)
printHtmlPart(6)
}
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(9)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(10)
expressionOut.print(error.field)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('message','g',16,['error':(error)],-1)
printHtmlPart(13)
})
invokeTag('eachError','g',17,['bean':(this.musicAsset),'var':("error")],3)
printHtmlPart(14)
})
invokeTag('hasErrors','g',19,['bean':(this.musicAsset)],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(15)
invokeTag('hiddenField','g',21,['name':("version"),'value':(this.musicAsset?.version)],-1)
printHtmlPart(16)
invokeTag('all','f',23,['bean':("musicAsset")],-1)
printHtmlPart(17)
expressionOut.print(message(code: 'default.button.update.label', default: 'Update'))
printHtmlPart(18)
})
invokeTag('form','g',29,['resource':(this.musicAsset),'method':("PUT")],2)
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',31,[:],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1466758936869L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
