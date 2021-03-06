package edu.ucsf.rbvi.setsApp.internal.tasks;

import org.cytoscape.model.CyEdge;
import org.cytoscape.model.CyNode;
import org.cytoscape.task.AbstractEdgeViewTaskFactory;
import org.cytoscape.task.AbstractNodeViewTaskFactory;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.View;
import org.cytoscape.work.TaskIterator;

import edu.ucsf.rbvi.setsApp.internal.model.SetsManager;

public class AddEdgeViewTaskFactory extends AbstractEdgeViewTaskFactory {
	
	private SetsManager mgr;
	public AddEdgeViewTaskFactory (SetsManager manager) {
		mgr = manager;
	}
	
	public boolean isReady(View<CyEdge> edgeView, CyNetworkView networkView) {
		if (super.isReady(edgeView, networkView) && mgr.setsCount() == 0) return false;
		else return true;
	}
	
	public TaskIterator createTaskIterator(View<CyEdge> arg0, CyNetworkView arg1) {
		return new TaskIterator(new AddEdgeTask(mgr, arg0.getModel()));
	}

}
