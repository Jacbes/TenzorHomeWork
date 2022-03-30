class Folder(val childs: MutableList<AbstractFileSystemNode> = mutableListOf()) : AbstractFileSystemNode() {
    override var name: String = ""
        get() = "$field/"

    constructor(
        inName: String,
        inParent: AbstractFileSystemNode?,
        vararg inNodes: AbstractFileSystemNode
    ) : this() {
        name = inName
        if (inParent is Folder) {
            parent = inParent
            inParent.childs.add(this)
        }
        for (node in inNodes) {
            childs.add(node)
            if (node is Folder) {
                val parentNode = node.parent as Folder
                parentNode.childs.remove(node)
            }
            node.parent = this
        }
    }
}
