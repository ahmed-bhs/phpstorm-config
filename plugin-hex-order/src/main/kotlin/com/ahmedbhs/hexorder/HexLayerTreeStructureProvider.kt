package com.ahmedbhs.hexorder

import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.projectView.TreeStructureProvider
import com.intellij.ide.projectView.ViewSettings
import com.intellij.ide.projectView.impl.nodes.PsiDirectoryNode
import com.intellij.ide.util.treeView.AbstractTreeNode
import com.intellij.psi.PsiDirectory

private val LAYER_WEIGHT = mapOf(
    "Infrastructure" to 10,
    "Application" to 20,
    "Domain" to 30,
)

class HexLayerTreeStructureProvider : TreeStructureProvider {
    override fun modify(
        parent: AbstractTreeNode<*>,
        children: MutableCollection<AbstractTreeNode<*>>,
        settings: ViewSettings?,
    ): MutableCollection<AbstractTreeNode<*>> {
        return children.map { node ->
            val value = node.value
            if (node is PsiDirectoryNode && value is PsiDirectory && LAYER_WEIGHT.containsKey(value.name)) {
                HexLayerDirectoryNode(node, LAYER_WEIGHT.getValue(value.name))
            } else {
                node
            }
        }.toMutableList()
    }
}

private class HexLayerDirectoryNode(
    original: PsiDirectoryNode,
    private val sortWeight: Int,
) : PsiDirectoryNode(original.project, original.value as PsiDirectory, original.settings) {

    override fun getTypeSortWeight(sortByType: Boolean): Int = sortWeight

    override fun update(presentation: PresentationData) {
        super.update(presentation)
    }
}
