'use strict'
$(function() {
	
	$(document).ready(function(){
		//test
		var test = '';
		localStorage.setItem(test, "デモです！");
		var yomikomi = localStorage.getItem(test);
		console.log(yomikomi);
		
		//Map形式で、JSON形式に変換の上localstrageにデータを保存
		var saveStorage = function(key,val){
		localStorage.setItem(key, JSON.stringify(val));
		};
		
		//localstrageのデータを取り出し、js形式に変換
		var getStorage = function(key){
		var obj = localStorage.getItem(key);
		var obj2 = JSON.parse(obj);
		console.log(obj2);
		return obj2;
		};
		
		//商品名、価格を変数にセット→関数を呼び出してデータをlocalstrageに保存
		var add = function(){
			var name = $("#itemname").val();
			console.log(name);
				price = $("#itemprice").val();
			console.log(price);
			addItem(name,price);
			saveItem(name,price);
		};

		//商品詳細を開いた際、データが送信、表示されるよう設定
		var addItem = function(name,price){
			console.log('here');
		    var template =
                    '<div  id="name" class="form-control" readonly="readonly">%s</div>' +
         			'<div class="form-control" rows="3" id="price" readonly="readonly">%s</div>';
                    template = template.replace('%s',name).replace('%s',price);


			$("#checkeditem").append(template);

			$("#itemname").val('');
			$("#itemprice").val('');
		}
		
			var storageKey = 'itemObj';

		//送信されたデータを配列形式でlocalstrageに保存
		var saveItem = function(name,price){
			itemArr = [];
			
			var itemObj = {
			name : name,
			price : price
			};
			itemArr.push(itemObj);
			console.log(itemObj);
			saveStorage(storageKey,itemArr);
		}
		
		//保存データの取得
		var readItem = function(){
			var itemObjs = getStorage(storageKey);
			console.log(itemObjs);
			if (itemObjs.length === null) return;
			for (var i = 0; i < itemObjs.length; i ++) {
				var itemObj = itemObjs[i];
				var name = itemObj.name;
				var price = itemObj.price;
				var itemObj = {
					name : name,
					price : price
				};
			itemArr.push(itemObj);
			saveStorage(storageKey,itemArr);
				addItem(name,price);
			};
		};
		
		
		//クリックで閲覧データ追加
		$(document).on('click','#showitems',function(){
			console.log('here');
			add();
		});
	
		//ページ読込み時にメモ復帰
		readItem();
	
	});
	
	
});