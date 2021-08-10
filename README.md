
AndroidMaterialSheet
---------------------
Avoid boilerplate code to create and show bottom sheet and receive event with fragment result api


Usage
-------
####  Confirmation Sheet
<img src="https://github.com/Nageshks/AndroidMaterialSheet/blob/main/confirmation_sheet_sample.jpg" width="200" height="300" align="right">

```kotlin
val dialog = ConfirmationSheet.create("CLEAR_HISTORY_REQUEST_KEY","Clear History")
showDialog(dialog)
```
**Behaviour**
- [x] Return true or false by ConfirmationSheet.isConfirmed(receivedBudle)
- [x] Always return result even click outside by user as false
- [x] Survive configuration change
- [x] Pass extra data to handle instantly when result received
- [x] Currently support only single design as below


Download
--------

```groovy
implementation("io.github.nageshks.materialsheet:materialsheet:0.1")
```

License
-------

    Copyright (C) 2021 Nagesh Empire

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

