/*
 * Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.hadoop.hoya.yarn.api

import groovy.util.logging.Commons
import org.apache.hadoop.hoya.api.ClusterDescription
import org.apache.hadoop.hoya.yarn.cluster.YarnMiniClusterTestBase
import org.junit.Test

/**
 test CD serialization/deserialization to and from JSON
 */
@Commons
class TestClusterDescriptionMapping extends YarnMiniClusterTestBase {


  ClusterDescription createCD() {
    ClusterDescription cd = new ClusterDescription();
    cd.name = "test"
    cd.state = ClusterDescription.STATE_STARTED;
    cd.maxMasterNodes = cd.minMasterNodes = 1;
    cd.masterNodes = [new ClusterDescription.ClusterNode("this")]
    cd.startTime = System.currentTimeMillis()

    return cd;
  }

  ClusterDescription parse(String s) {
    try {
      return ClusterDescription.fromJson(s);
    } catch (IOException e) {
      log.info("exception parsing: \n" + s);
      throw e;
    }
  }

  ClusterDescription roundTrip(ClusterDescription src) {
    return parse(src.toJsonString());
  }

  @Test
  public void testJsonify() throws Throwable {
    log.info(createCD().toJsonString())
  }

  @Test
  public void testEmptyRoundTrip() throws Throwable {
    roundTrip(new ClusterDescription())
  }

  @Test
  public void testRTrip() throws Throwable {
    roundTrip(createCD())
  }
}
