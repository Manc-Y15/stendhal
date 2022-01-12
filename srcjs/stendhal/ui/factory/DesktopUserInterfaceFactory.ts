/***************************************************************************
 *                (C) Copyright 2022-2022 - Faiumoni e. V.                 *
 ***************************************************************************
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU Affero General Public License as        *
 *   published by the Free Software Foundation; either version 3 of the    *
 *   License, or (at your option) any later version.                       *
 *                                                                         *
 ***************************************************************************/

import { UIComponentEnum } from "../UIComponentEnum";
import { ui } from "../UI";

import { Component } from "../toolkit/Compontent";
import { Panel } from "../toolkit/Panel";

import { BuddyListComponent } from "../component/BuddyListComponent";
import { MiniMapComponent } from "../component/MiniMapComponent";
import { PlayerStatsComponent } from "../component/PlayerStatsComponent";

export class DesktopUserInterfaceFactory {

	public create() {
		let topPanel = new Panel("topPanel");
		ui.registerComponent(UIComponentEnum.LeftPanel, topPanel);
		
		let leftPanel = new Panel("leftColumn");
		ui.registerComponent(UIComponentEnum.LeftPanel, leftPanel);

		this.add(leftPanel, UIComponentEnum.MiniMap, new MiniMapComponent());
		this.add(leftPanel, UIComponentEnum.PlayerStats, new PlayerStatsComponent());
		this.add(leftPanel, UIComponentEnum.BuddyList, new BuddyListComponent());


		let rightPanel = new Panel("rightColumn");
		ui.registerComponent(UIComponentEnum.RightPanel, rightPanel);

		let bottomPanel = new Panel("bottomPanel");
		ui.registerComponent(UIComponentEnum.BottomPanel, bottomPanel);
	}

	private add(panel: Panel, uiComponentEnum: UIComponentEnum, component: Component) {
		panel.add(component);
		ui.registerComponent(uiComponentEnum, component);
	}

}
