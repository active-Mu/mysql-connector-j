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

public interface CollectionStatement extends Statement {

    Result execute();

    Future<Result> executeAsync();

    interface AddStatement extends CollectionStatement {
    }

    interface RemoveStatement extends CollectionStatement {

        RemoveStatement orderBy(String sortFields);

        RemoveStatement limit(int numberOfRows);

    }

    interface FindStatement extends Statement {

        FindStatement fields(String searchFields);

        FindStatement groupBy(String searchFields);

        FindStatement having(String searchCondition);

        FindStatement sort(String sortFields);

        FindStatement skip(int limitOffset);

        FindStatement limit(int numberOfRows);

        FetchedDocs execute();

    }

    interface ModifyStatement extends CollectionStatement {

        ModifyStatement sort(String sortFields);

        ModifyStatement limit(int numberOfRows);

        ModifyStatement set(String fieldsAndValues);

        ModifyStatement change(String changeFields);

        ModifyStatement unset(String fields);

        ModifyStatement merge(String document);

        ArrayModifyStatement array();

        interface ArrayModifyStatement extends ModifyStatement {

            ModifyStatement splice(String field, int number1, int number2, String document);

            ModifyStatement insert(String field, int number, String document);

            ModifyStatement append(String field, String document);

            ModifyStatement delete(String field, int number);

            ModifyStatement remove(String field, String document);

        }
    }

}
