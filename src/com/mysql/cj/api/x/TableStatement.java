/*
  Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.

  The MySQL Connector/J is licensed under the terms of the GPLv2
  <http://www.gnu.org/licenses/old-licenses/gpl-2.0.html>, like most MySQL Connectors.
  There are special exceptions to the terms and conditions of the GPLv2 as it is applied to
  this software, see the FLOSS License Exception
  <http://www.mysql.com/about/legal/licensing/foss-exception.html>.

  This program is free software; you can redistribute it and/or modify it under the terms
  of the GNU General Public License as published by the Free Software Foundation; version 2
  of the License.

  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
  See the GNU General Public License for more details.

  You should have received a copy of the GNU General Public License along with this
  program; if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth
  Floor, Boston, MA 02110-1301  USA

 */

package com.mysql.cj.api.x;

import java.util.concurrent.Future;

public interface TableStatement extends Statement {

    Result execute();

    Future<Result> executeAsync();

    interface DeleteStatement extends TableStatement {

        DeleteStatement where(String searchCondition);

        DeleteStatement orderBy(String sortFields);

        DeleteStatement limit(int numberOfRows);

    }

    interface UpdateStatement extends TableStatement {

        UpdateStatement set(String fieldsAndValues);

        UpdateStatement where(String searchCondition);

        UpdateStatement orderBy(String sortFields);

        UpdateStatement limit(int numberOfRows);
    }

    interface InsertStatement extends TableStatement {

        InsertStatement values(String values);

    }

    interface SelectStatement extends TableStatement {

        SelectStatement where(String searchCondition);

        SelectStatement groupBy(String searchFields);

        SelectStatement having(String searchCondition);

        SelectStatement orderBy(String sortFields);

        SelectStatement limit(int numberOfRows);

        SelectStatement limit(int limitOffset, int numberOfRows);

        //SelectStatement fetch(Object callback); // not supported in v1
    }

}
