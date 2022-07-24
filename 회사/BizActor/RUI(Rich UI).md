# RUI(Rich UI)

Cross Browser/Cross Platform를 지원해야 하는 웹에 최적화된 성능을 제공하는 웹 표준 기술을 활용한 Grid 컴포넌트 라이브러리



**RUI는 5개의 라이브러리를 제공**

* rui_base.js
* rui_core.js
* rui_ui.js
* rui_form.js
* rui_grid.js



**DataSet**

JSON으로 데이터를 주고 받는 데이터

* LJsonDataSet 클래스를 통해서 JSON 객체를 이용함
* 비동기식으로 데이터를 로드

~~~js
var dataSet = new Rui.data.LJsonDataSet({
    id: "dataSet",
    fields: [
        { id: "Author"},
        { id: "BOOKID"}
    ]
});
~~~

~~~ㅓㄴ
dataSet.load({
	url:'/cm/service/rui.ncd',
	params: {
		actID: 'BRBOOKMasterSearch',
		baRq : 'SearchInfo',
		baRs : 'BookInfo',
		'SearchInfo.CLASSCD' : 'AA',
		'SearchInfo.BOOKNM' : 'J2EE10',
		'SearchInfo.KEYWPRD' : 'J2EE',
	},
	callback : {
		success : function(e) {
			const records = JSON.parse(e.responseText)[0];
			dataSet.loadData(records);
			}
	}
})
~~~



**DataSet에서 발생하는 CunstomEvents**

* add
* update
* load

~~~js
dataSet.on('load', function(e) {
    ...
})

dataSet.on('update', function(e) {
    ...
})
~~~



**서버로 JSON 형식으로 DAtaSet을 보내주기 위한 방법**

~~~js
var dm = new Rui.data.LDataSetManager();

//업데이트 성공시
dm.success
//업데이트 실패시
dm.fail
//데이터 변경시, 데이터 여러개 받을 때
dm.updateDataSet({
    
})
~~~



**Rui.ui.grid.LColumnModel**

~~~js
var columnModel = new Rui.ui.grid.LColumnModel({
    groupMerge: true,
    autoWidth: true,
    columns: [
        { field: 'col2', label: 'Col2', sortable: true, renderer: function...}
        //렌더러가 뭐징..?
    ]
})
~~~



* url : NCD API URL
* params {object} NCD에서 정보를 가져오기 위한 params 객체
* params.actID {string} NCD BR 명
* params.baRq {string} NCD BR InDataSet명
* params.baRs {string} NCD BR OutDataSet명
* callback {} NCD에ㅓ 정보를 가져온 후 수행할 callback
* callback.success {}
* callback.failure {}



~~~js
//엑셀 저장
onClick: function(e) {
    var targetEl = Rui.get(e.target);
    if (targetEl.hasClass('saveExcel')) {
        if(typeof Rui.ui.grid.LGridView === 'undefined') 
            Rui.includeJs(ruiRootPath + '/plugins/ui/grid/LGridView.js', true);
        if(typeof Rui.ui.grid.LGridPanel.prototype.saveExcel === 'undefined') 
            Rui.includeJs(ruiRootPath + '/plugins/ui/grid/LGridPanelExt.js', true);
        var fileName = (gridPanel.title || '');
        if(fileName) fileName += '_' + Rui.util.LDate.format(new Date(), { format: '%q' }) + '.xls';
        gridView.gridPanel.saveExcel(fileName);
}
~~~



* 데이터는 모두 대문자나 소문자로 되어있다. upper()를 통해 DA도 대문자로 다 만들고...

ColumnModel