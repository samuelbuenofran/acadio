/*******************************************************************************
 * Copyright (c) 2011, 2023 Google, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Google, Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.wb.swing;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;

/**
 * EN: Cyclic focus traversal policy based on array of components.
 * <p>
 * This class may be freely distributed as part of any application or plugin.
 * 
 * PT: Política de travessia de foco cíclica baseada em uma matriz de
 * componentes. Esta classe pode ser distribuída livremente como parte de
 * qualquer aplicativo ou plug-in.
 *
 * @author scheglov_ke
 */
public class FocusTraversalOnArray extends FocusTraversalPolicy {
	private final Component m_Components[];

	////////////////////////////////////////////////////////////////////////////
	//
	// Constructor
	//
	////////////////////////////////////////////////////////////////////////////
	/**
	 * EN: Constructor, which takes array of components, which will be used as focus
	 * cycle.
	 * 
	 * PT: Construtor, que leva uma matriz de componentes, que serão usados como
	 * ciclo de foco.
	 * 
	 * @param components the components to use in the focus cycle
	 */
	public FocusTraversalOnArray(Component components[]) {
		m_Components = components;
	}

	////////////////////////////////////////////////////////////////////////////
	//
	// Utilities
	//
	////////////////////////////////////////////////////////////////////////////
	/**
	 * EN: Returns the next index cycle.
	 * 
	 * PT: Retorna o próximo índice do ciclo.
	 * 
	 * @param index
	 * @param delta
	 * @return
	 */
	private int indexCycle(int index, int delta) {
		int size = m_Components.length;
		int next = (index + delta + size) % size;
		return next;
	}

	/**
	 * EN: Returns the next component in the cycle.
	 * 
	 * PT: Retorna o próximo componente no ciclo.
	 * 
	 * @param currentComponent
	 * @param delta
	 * @return
	 */
	private Component cycle(Component currentComponent, int delta) {
		int index = -1;
		loop: for (int i = 0; i < m_Components.length; i++) {
			Component component = m_Components[i];
			for (Component c = currentComponent; c != null; c = c.getParent()) {
				if (component == c) {
					index = i;
					break loop;
				}
			}
		}
		// try to find enabled component in "delta" direction
		int initialIndex = index;
		while (true) {
			int newIndex = indexCycle(index, delta);
			if (newIndex == initialIndex) {
				break;
			}
			index = newIndex;
			//
			Component component = m_Components[newIndex];
			if (component.isEnabled() && component.isVisible() && component.isFocusable()) {
				return component;
			}
		}
		// not found
		return currentComponent;
	}

	////////////////////////////////////////////////////////////////////////////
	//
	// FocusTraversalPolicy
	//
	////////////////////////////////////////////////////////////////////////////
	/**
	 * EN: Returns the next component in the cycle. PT: Retorna o próximo componente
	 * no ciclo.
	 */
	@Override
	public Component getComponentAfter(Container container, Component component) {
		return cycle(component, 1);
	}

	/**
	 * EN: Returns the previous component in the cycle. PT: Retorna o componente
	 * anterior no ciclo.
	 */
	@Override
	public Component getComponentBefore(Container container, Component component) {
		return cycle(component, -1);
	}

	/**
	 * EN: Returns the first component in the cycle. PT: Retorna o primeiro
	 * componente no ciclo.
	 */
	@Override
	public Component getFirstComponent(Container container) {
		return m_Components[0];
	}

	/**
	 * EN: Returns the last component in the cycle. PT: Retorna o último componente
	 * no ciclo.
	 */
	@Override
	public Component getLastComponent(Container container) {
		return m_Components[m_Components.length - 1];
	}

	/**
	 * EN: Returns the default component in the cycle. PT: Retorna o componente
	 * padrão no ciclo.
	 */
	@Override
	public Component getDefaultComponent(Container container) {
		return getFirstComponent(container);
	}
}