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
 *
 * Copyright 2011-2017 Peter Güttinger and contributors
 */
package ch.njol.skript.expressions;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import ch.njol.skript.Skript;
import ch.njol.skript.classes.Changer.ChangeMode;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import ch.njol.skript.expressions.base.SimplePropertyExpression;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.skript.util.Date;
import ch.njol.skript.util.Timespan;
import ch.njol.util.Kleenean;
import ch.njol.util.coll.CollectionUtils;

@Name("Time Since")
@Description("The time that has passed since a date. If the given date is in the future, a value will not be returned.")
@Examples("send \"You died %time since % ago!\" to player")
@Since("INSERT VERSION")
public class ExprTimeSince extends SimplePropertyExpression<Date, Timespan> {

	static {
		Skript.registerExpression(ExprTimeSince.class, Timespan.class, ExpressionType.PROPERTY, "time since %dates%");
	}

	@Override
	@Nullable
	public Timespan convert(Date date) {

		Date now = Date.now();

		/*
		 * This condition returns whether the date the player is using is
		 * before the current date, the same as the current date, or after the current date.
		 * A value less than 0 indicates that the new date is BEFORE the current date.
		 * A value of 0 indicates that the new date is the SAME as the current date.
		 * A value greater than 0 indicates that the new date is AFTER the current date.
		 */
		if (date.compareTo(now) < 1)
			return date.difference(now);
		return null;
	}

	@Override
	public Class<? extends Timespan> getReturnType() {
		return Timespan.class;
	}

	@Override
	protected String getPropertyName() {
		return "time since";
	}

}
