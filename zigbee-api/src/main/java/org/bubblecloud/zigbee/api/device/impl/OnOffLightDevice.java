/*
   Copyright 2008-2013 CNR-ISTI, http://isti.cnr.it
   Institute of Information Science and Technologies 
   of the Italian National Research Council 


   See the NOTICE file distributed with this work for additional 
   information regarding copyright ownership

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package org.bubblecloud.zigbee.api.device.impl;

import org.bubblecloud.zigbee.ZigbeeApiConstants;
import org.bubblecloud.zigbee.network.ZigbeeEndpoint;
import org.bubblecloud.zigbee.api.*;
import org.bubblecloud.zigbee.api.cluster.general.Groups;
import org.bubblecloud.zigbee.api.cluster.general.OnOff;
import org.bubblecloud.zigbee.api.cluster.general.Scenes;
import org.bubblecloud.zigbee.api.cluster.measureament_sensing.OccupacySensing;
import org.bubblecloud.zigbee.api.device.lighting.OnOffLight;
import org.bubblecloud.zigbee.ZigbeeApiContext;

/**
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @version $LastChangedRevision: 799 $ ($LastChangedDate: 2013-08-06 19:00:05 +0300 (Tue, 06 Aug 2013) $)
 * @since 0.1.0
 */
public class OnOffLightDevice extends DeviceBase implements OnOffLight {

    private OnOff onOff;
    private Scenes scenes;
    private Groups groups;
    private OccupacySensing occupancySensing;

    public OnOffLightDevice(ZigbeeApiContext ctx, ZigbeeEndpoint zbDevice) throws ZigbeeDeviceException {
        super(ctx, zbDevice);
        onOff = (OnOff) getCluster(ZigbeeApiConstants.CLUSTER_ID_ON_OFF);
        groups = (Groups) getCluster(ZigbeeApiConstants.CLUSTER_ID_GROUPS);
        scenes = (Scenes) getCluster(ZigbeeApiConstants.CLUSTER_ID_SCENES);
        occupancySensing = (OccupacySensing) getCluster(ZigbeeApiConstants.CLUSTER_ID_OCCUPANCY_SENSING);
    }


    public Groups getGroups() {
        return groups;
    }

    public OccupacySensing getOccupacySensing() {
        return occupancySensing;
    }

    public OnOff getOnOff() {
        return onOff;
    }

    public Scenes getScenes() {
        return scenes;
    }


    @Override
    public String getDeviceType() {
        return OnOffLight.NAME;
    }

    final static DeviceDescription DEVICE_DESCRIPTOR = new AbstractDeviceDescription() {

        public int[] getCustomClusters() {
            return OnOffLight.CUSTOM;
        }

        public int[] getMandatoryCluster() {
            return OnOffLight.MANDATORY;
        }

        public int[] getOptionalCluster() {
            return OnOffLight.OPTIONAL;
        }

        public int[] getStandardClusters() {
            return OnOffLight.STANDARD;
        }

    };

    @Override
    public DeviceDescription getDescription() {
        return DEVICE_DESCRIPTOR;
    }


}
