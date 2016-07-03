import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_ftmedia_plugins_ftLibrary_videoAssetindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/videoAsset/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'videoAsset.label', default: 'VideoAsset'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('actionSubmit','g',25,['class':("btn btn-success"),'value':("Filtern"),'action':("filter")],-1)
printHtmlPart(5)
})
invokeTag('form','g',26,['controller':("videoAsset"),'method':("POST")],2)
printHtmlPart(6)
for( video in (videoAssetList) ) {
printHtmlPart(7)
expressionOut.print(video.id)
printHtmlPart(8)
expressionOut.print(video.id)
printHtmlPart(9)
expressionOut.print(video.title)
printHtmlPart(10)
if(true && (video.year)) {
printHtmlPart(11)
expressionOut.print(video.year)
printHtmlPart(12)
}
printHtmlPart(13)
}
printHtmlPart(14)
invokeTag('paginate','g',54,['total':(videoAssetCount ?: 0)],-1)
printHtmlPart(15)
})
invokeTag('captureBody','sitemesh',65,[:],1)
printHtmlPart(16)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1467380304251L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
