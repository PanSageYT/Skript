/**
 *   This file is part of Skript.
 *
 *  Skript is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Skript is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Skript.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright Peter Güttinger, SkriptLang team and contributors
 */
package ch.njol.skript.lang;

import ch.njol.skript.classes.Changer;
import ch.njol.util.Pair;
import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import java.util.Map;

/**
 * Used for returning a value with an index.
 *
 * @see Expression#getIndexed(Event)
 * @see Expression#supportsIndices(Changer.ChangeMode)
 * @param <T> type of value
 */
public class IndexedValue<T> extends Pair<String, T> {

	private static final long serialVersionUID = 6298110217058852616L;

	public IndexedValue(@Nullable String index, @Nullable T value) {
		super(index, value);
	}

	public IndexedValue(Map.Entry<String, T> entry) {
		super(entry);
	}

	@Nullable
	public String getIndex() {
		return getKey();
	}

	public boolean hasIndex() {
		return getIndex() != null;
	}

}
