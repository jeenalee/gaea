package bmeg.gaea.feature

import com.thinkaurelius.titan.core.TitanGraph
import gremlin.scala._

object Feature {
  val nameKey = Key[String]("name")

  def findSynonymVertex(graph: TitanGraph) (name: String): Option[Vertex] = {
    graph.V.hasLabel("featureSynonym").has(nameKey, name).out("synonymFor").headOption
  }

  def findSynonym(graph: TitanGraph) (name: String): Option[String] = {
    val values = findSynonymVertex(graph) (name).map(_.valueMap())
    values.map(_("name").asInstanceOf[String])
  }

  def findFeature(graph: TitanGraph) (name: String): Vertex = {
    findSynonymVertex(graph) (name).getOrElse {
      val synonym = graph.V.hasLabel("featureSynonym").has(nameKey, name).headOption.getOrElse {
        graph + ("featureSynonym", nameKey -> name)
      }

      val feature = graph.V.hasLabel("feature").has(nameKey, name).headOption.getOrElse {
        graph + ("feature", nameKey -> name)
      }

      synonym --- ("synonymFor") --> feature
      feature
    }
  }
}
