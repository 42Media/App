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
invokeTag('stylesheet','asset',5,['src':("videoasset.css")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'videoAsset.label', default: 'VideoAsset'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
for( video in (videoAssetList) ) {
printHtmlPart(4)
expressionOut.print(video.id)
printHtmlPart(5)
expressionOut.print(video.id)
printHtmlPart(6)
expressionOut.print(video.title)
printHtmlPart(7)
expressionOut.print(video.year)
printHtmlPart(8)
}
printHtmlPart(9)
invokeTag('paginate','g',46,['total':(videoAssetCount ?: 0)],-1)
printHtmlPart(10)
invokeTag('message','g',59,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(11)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(12)
invokeTag('message','g',62,['code':("default.home.label")],-1)
printHtmlPart(13)
createTagBody(2, {->
invokeTag('message','g',63,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',63,['class':("create"),'action':("create")],2)
printHtmlPart(14)
invokeTag('message','g',67,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(15)
if(true && (flash.message)) {
printHtmlPart(16)
expressionOut.print(flash.message)
printHtmlPart(17)
}
printHtmlPart(18)
invokeTag('table','f',71,['collection':(videoAssetList)],-1)
printHtmlPart(19)
invokeTag('paginate','g',74,['total':(videoAssetCount ?: 0)],-1)
printHtmlPart(20)
})
invokeTag('captureBody','sitemesh',77,[:],1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1466939995567L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
