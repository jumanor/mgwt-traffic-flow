/*
 * Copyright 2015 Wayne Dyck
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.imaginedreal.mgwt.trafficflow.client;

import com.imaginedreal.mgwt.trafficflow.client.activities.MenuActivity;
import com.imaginedreal.mgwt.trafficflow.client.activities.seattle.SeattlePlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppNavActivityMapper implements ActivityMapper {

	private final ClientFactory clientFactory;

	public AppNavActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	private MenuActivity menuActivity;

	private Activity getMenuActivity() {
		if (menuActivity == null) {
			menuActivity = new MenuActivity(clientFactory);
		}
		
		return menuActivity;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof SeattlePlace) {
			return getMenuActivity();
		}

		return new MenuActivity(clientFactory);
	}
}
