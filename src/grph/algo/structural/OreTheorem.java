/* (C) Copyright 2009-2013 CNRS (Centre National de la Recherche Scientifique).

Licensed to the CNRS under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The CNRS licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.

*/

/* Contributors:

Luc Hogie (CNRS, I3S laboratory, University of Nice-Sophia Antipolis) 
Aurelien Lancin (Coati research team, Inria)
Christian Glacet (LaBRi, Bordeaux)
David Coudert (Coati research team, Inria)
Fabien Crequis (Coati research team, Inria)
Grégory Morel (Coati research team, Inria)
Issam Tahiri (Coati research team, Inria)
Julien Fighiera (Aoste research team, Inria)
Laurent Viennot (Gang research-team, Inria)
Michel Syska (I3S, Université Cote D'Azur)
Nathann Cohen (LRI, Saclay) 
Julien Deantoin (I3S, Université Cote D'Azur, Saclay) 

*/
 
 package grph.algo.structural;

import grph.Grph;
import grph.GrphAlgorithm;

/**
 * Ore theorem considers the sum of the degrees of any two non-adjacent
 * vertices: if this sum is always at least equal to the total number of
 * vertices in the graph, then the graph is Hamiltonian.
 * 
 * http://testard.frederic.pagesperso-orange.fr/mathematiques/coursGraphes/
 * chapitre02/cours/chapitre02_1.htm
 * 
 * @author lhogie
 * 
 */

public class OreTheorem extends GrphAlgorithm<Boolean>
{
    /**
     * Are we sure the graph is hamiltonian?
     */
    @Override
    public Boolean compute(Grph g)
    {
	int n = g.getVertices().size();

	for (int v : g.getVertices().toIntArray())
	{
	    for (int w : g.getVertices().toIntArray())
	    {
		if (!g.areVerticesAdjacent(v, w))
		{
		    int dv = g.getVertexDegree(v, Grph.TYPE.edge, Grph.DIRECTION.in_out);
		    int dw = g.getVertexDegree(w, Grph.TYPE.edge, Grph.DIRECTION.in_out);

		    if (dv + dw < n)
		    {
			return false;
		    }
		}
	    }
	}

	return true;
    }



}
