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

package org.apache.hadoop.hoya.exceptions;

import org.apache.hadoop.hoya.HoyaExitCodes;
import org.apache.hadoop.yarn.service.launcher.ServiceLaunchException;

public class HoyaException extends ServiceLaunchException implements
                                                          HoyaExitCodes {
  public HoyaException() {
    super(EXIT_EXCEPTION_THROWN, "HoyaException");
  }

  public HoyaException(int code, String message) {
    super(code, message);
  }

  public HoyaException(String s) {
    super(EXIT_EXCEPTION_THROWN, s);
  }

  public HoyaException(String s, Throwable throwable) {
    super(EXIT_EXCEPTION_THROWN, s, throwable);
  }

  public HoyaException(int code, String s, Throwable throwable) {
    super(EXIT_EXCEPTION_THROWN, s, throwable);
  }


}
