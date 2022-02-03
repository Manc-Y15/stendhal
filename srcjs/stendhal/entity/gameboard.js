/***************************************************************************
 *                   (C) Copyright 2003-2018 - Stendhal                    *
 ***************************************************************************
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU Affero General Public License as        *
 *   published by the Free Software Foundation; either version 3 of the    *
 *   License, or (at your option) any later version.                       *
 *                                                                         *
 ***************************************************************************/


"use strict";

var marauroa = window.marauroa = window.marauroa || {};

var GameBoard = require("../../../build/ts/entity/GameBoard").GameBoard;

marauroa.rpobjectFactory["game_board"] = GameBoard;
