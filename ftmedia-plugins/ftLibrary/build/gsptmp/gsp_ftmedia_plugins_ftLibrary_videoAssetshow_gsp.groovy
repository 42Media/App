import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_ftmedia_plugins_ftLibrary_videoAssetshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/videoAsset/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('set','g',4,['var':("entityName"),'value':(message(code: 'videoAsset.label', default: 'VideoAsset'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',5,['code':("default.show.label"),'args':([entityName])],-1)
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
invokeTag('message','g',9,['code':("default.show.label"),'args':([videoAsset])],-1)
printHtmlPart(4)
expressionOut.print(videoAsset.id)
printHtmlPart(5)
invokeTag('display','f',17,['bean':("videoAsset")],-1)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
createTagBody(3, {->
invokeTag('message','g',21,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',21,['data-toggle':("modal"),'data-target':("#modal-music"),'class':("edit btn btn-primary"),'action':("edit"),'resource':(this.videoAsset)],3)
printHtmlPart(8)
expressionOut.print(message(code: 'default.button.delete.label', default: 'Delete'))
printHtmlPart(9)
expressionOut.print(message(code: 'default.button.delete.confirm.message', default: 'Are you sure?'))
printHtmlPart(10)
})
invokeTag('form','g',24,['resource':(this.videoAsset),'method':("DELETE")],2)
printHtmlPart(11)
})
invokeTag('captureBody','sitemesh',29,[:],1)
printHtmlPart(12)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1467660388502L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
