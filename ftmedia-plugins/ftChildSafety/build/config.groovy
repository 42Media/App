
withConfig(configuration) {
    inline(phase: 'CONVERSION') { source, context, classNode ->
        classNode.putNodeMetaData('projectVersion', '0.1')
        classNode.putNodeMetaData('projectName', 'ftmedia-plugins/ftChildSafety')
        classNode.putNodeMetaData('isPlugin', 'true')
    }
}
