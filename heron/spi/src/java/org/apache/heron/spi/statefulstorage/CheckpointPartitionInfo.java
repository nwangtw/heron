/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.heron.spi.statefulstorage;

import org.apache.heron.proto.system.PhysicalPlans;

/**
 * The information for one checkpoint partition. It can be used to reference checkpoint and
 * metadata (partitionId is ignored).
 */
public class CheckpointPartitionInfo {
  // The checkpoint ID under the topology.
  private final String checkpointId;
  // The name of the component.
  private final String componentName;
  // The checkpoint partition id under the component. For example, it could be instance
  // index if each instance has one partition; or it can also be other kind of ids that are
  // consistent for the component.
  private final int partitionId;

  public CheckpointPartitionInfo(String checkpointId, PhysicalPlans.Instance instance) {

    this.checkpointId = checkpointId;
    this.componentName = instance.getInfo().getComponentName();
    this.partitionId = instance.getInfo().getComponentIndex();
  }

  public String getCheckpointId() {
    return checkpointId;
  }

  public String getComponent() {
    return componentName;
  }

  public int getPartitionId() {
    return partitionId;
  }

  @Override
  public String toString() {
    return String.format("CheckpointPartitionInfo(%s %s %d)",
                         checkpointId, componentName, partitionId);
  }
}
