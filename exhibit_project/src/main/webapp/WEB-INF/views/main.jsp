<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서울의 전시회: 일정 및 정보</title>
    <style> /* 커스텀 오버레이 스타일 적용 */
    .wrap {position: absolute;left: 0;bottom: 40px;width: 288px;height: 132px;margin-left: -144px;text-align: left;overflow: hidden;font-size: 12px;font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;line-height: 1.5;}
    .wrap * {padding: 0;margin: 0;}
    .wrap .info {width: 286px;height: 120px;border-radius: 5px;border-bottom: 2px solid #ccc;border-right: 1px solid #ccc;overflow: hidden;background: #fff;}
    .wrap .info:nth-child(1) {border: 0;box-shadow: 0px 1px 2px #888;}
    .info .title {padding: 5px 0 0 10px;height: 30px;background: #eee;border-bottom: 1px solid #ddd;font-size: 18px;font-weight: bold;}
    .info .close {position: absolute;top: 10px;right: 10px;color: #888;width: 17px;height: 17px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');}
    .info .close:hover {cursor: pointer;}
    .info .body {position: relative;overflow: hidden;}
    .info .desc {position: relative;margin: 13px 0 0 90px;height: 75px;}
    .desc .ellipsis {overflow: hidden;text-overflow: ellipsis;white-space: nowrap;}
    .desc .jibun {font-size: 11px;color: #888;margin-top: -2px;}
    .info .img {position: absolute;top: 6px;left: 5px;width: 73px;height: 71px;border: 1px solid #ddd;color: #888;overflow: hidden;}
    .info:after {content: '';position: absolute;margin-left: -12px;left: 50%;bottom: 0;width: 22px;height: 12px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}
    .info .link {color: #5085BB;}
</style>
<link href="${cp}/resources/css/styles.css" rel="stylesheet" />
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6e57a7dfd7dcac058aee9d6aac467f19&libraries=services,clusterer,drawing"></script>
<script>
	function init(){
		var mapContainer = document.getElementById('map');
		var mapOption = {
			center : new kakao.maps.LatLng("37.55627537083571", "126.97239492638606"), // 지도 중심(서울역)
			level : 7
		};

		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도 생성

		// 지도상 마커를 표시할 위치와 title 객체 배열
		var posArr = new Array()
		var positions = new Array()
		
		<c:forEach var="exItem" items="${exList}" varStatus="status">
			posArr.push({name: "${exItem.name}",
						address: "${exItem.address}",
						phone: "${exItem.phone}",
						website: "${exItem.website}",
						thumbnail: "${exItem.thumbnail}",
						latClick: "${exItem.latClick}",
						lngClick: "${exItem.lngClick}"})
						
			positions.push({title: "${exItem.name}",
						latlng: new kakao.maps.LatLng("${exItem.latClick}",  "${exItem.lngClick}")})
		</c:forEach>

		var imageSrc = "${cp}/resources/image/arrow.png";
		var markers = []
		var clickedOverlay = null;
		
		for (var i = 0; i < positions.length; i++) {

			var imageSize = new kakao.maps.Size(35, 35); // 마커 크기
			var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); // 해당 이미지로 마커 생성

			// 마커 띄우기
			var marker = new kakao.maps.Marker({
				map : map, // 마커를 표시할 지도
				position : positions[i].latlng, // 마커를 표시할 위치
				title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
				image : markerImage // 마커 이미지
			});
			
			markers.push(marker)
			
			// 커스텀오버레이에 표시할 컨텐츠 DOM 생성
			// DOM Element로 직접 객체를 만들어 핸들링하게 되면 커스텀 오버레이 내부에서 일어나는 이벤트(setContent) 사용 가능
			var content = document.createElement('div');
			content.className = "wrap";
			
			var info = document.createElement('div');
			info.className = "info"			
			content.appendChild(info);

			// 오버레이 타이틀
			var title = document.createElement('div');
			title.className = "title"
			title.appendChild(document.createTextNode(positions[i].title));
			info.appendChild(title);

			// 오버레이 닫기 버튼
			var closeBtn = document.createElement('div');
			closeBtn.className = "close";
			closeBtn.setAttribute("title","닫기");
			closeBtn.onclick = function() { overlay.setMap(null); };
			title.appendChild(closeBtn);

			var bodyContent = document.createElement("div");
			bodyContent.className = "body";
			info.appendChild(bodyContent);

			var imgDiv = document.createElement("div");
			imgDiv.className = "img";
			bodyContent.appendChild(imgDiv);

			// 오버레이 이미지
			var imgContent = document.createElement("img");
			imgContent.setAttribute("src", posArr[i].thumbnail);
			imgContent.setAttribute("width", "73");
			imgContent.setAttribute("heigth", "70");
			imgDiv.appendChild(imgContent);

			var descContent = document.createElement("div");
			descContent.className = "desc"
			bodyContent.appendChild(descContent);

			// 오버레이 주소			
			var addressContent = document.createElement("div");
			addressContent.className = "ellipsis";
			addressContent.appendChild(document.createTextNode(posArr[i].address));
			descContent.appendChild(addressContent);

			// 오버레이 지번(전화번호로 대체)
			var address2Content = document.createElement("div");
			address2Content.className = "jibun ellipsis";
			address2Content.appendChild(document.createTextNode(posArr[i].phone));
			descContent.appendChild(address2Content);

			var LinkDiv = document.createElement("div");
			descContent.appendChild(LinkDiv);

			// 오버레이 링크
			var LinkContent = document.createElement("a");
			var url = posArr[i].website;
			if (url == "")
			{
				url = "javascript:"
			}
			LinkContent.setAttribute("href", url);
			if (url != "javascript:")
			{
				LinkContent.setAttribute("target", "_blank");
			}
			LinkContent.className = "link";
			LinkContent.appendChild(document.createTextNode("홈페이지"));
			LinkDiv.appendChild(LinkContent);
		
			// 마커 위에 커스텀오버레이 표시
			var overlay = new kakao.maps.CustomOverlay({
			    content: content,
			    position: marker.getPosition()
			});

			
		    // 마커에 열기, 닫음 이벤트 등록 및 즉시 호출하여 클로저(for문때문)
		    (function(marker, overlay) {
		        kakao.maps.event.addListener(marker, 'click', function() {
				    // clickedOverlay에 할당되어 있는 CustomOverlay를 지우고 
				    // 현재 클릭된 overlay를 해당 변수에 재할당하여 계속하여 이전 overlay를 지우는 방식
		            if(clickedOverlay){ 
		            	clickedOverlay.setMap(null);
		            }
		        	overlay.setMap(map); 
		        	clickedOverlay = overlay; 
		        });
		        
		        closeBtn.addEventListener('click', function() {
		        	overlay.setMap(null);
		        });
		    })(marker, overlay);
			
		}
		return map
	}

	 
</script>
</head>
<body>
<%@include file="header.jsp"%>
	<section>
		<div id="menu_wrap"  class="bg_white">
			<div class="option">
				<div>
					<form action='${cp}/exhibit' method='get'>
						<input type="text" name="name" id="name" placeholder="어떤 전시를 찾으시나요?">
					</form>
				</div>
			</div>
			<br/>
			<ul id="placesList">
				<c:if test="${empty exhibit}">
					<!-- 검색 액션이 없을 시 -->
					각 마커에 뜨는 장소를 <br>
		        	키워드에 검색해 주시면 <br>
		        	해당 장소의 전시회 정보를 <br>
		        	볼 수 있습니다. <br>
				</c:if>

				<c:if test="${!empty exhibit}">
					<c:if test="${exhibit.name == '서울역'}">
		        		검색 결과가 없습니다.
					</c:if>
					
					<c:if test="${exhibit.name != '서울역'}">
		        	장소: ${exhibit.name}  <br>
                    주소: ${exhibit.address} <br>
                    지하철: ${exhibit.metro} <br>
                    전시회: ${exhibit.subject} <br>
                    진행기간: ${exhibit.periodDate} <br>
                    이용시간: ${exhibit.periodTime} <br>
                    휴일: ${exhibit.dayOff} <br>
                    이용요금: ${exhibit.fare} <br>
                    티켓예매처: ${exhibit.farePlace} <br>
                    웹사이트: ${exhibit.website} <br>
                    전화번호: ${exhibit.phone} <br>   
					</c:if>
				</c:if>
			</ul>


			<div id="pagination"></div>
			</div>


		<!-- Page Content-->
		<div id="container">
			<div id="map"></div>
		</div>

		<script>var map = init();</script>
		
		<c:if test="${!empty exList}">
			<c:if test="${exhibit.name != '서울역'}">
				<c:forEach var="exItem" items="${exList}" varStatus="status">
					<c:out value="${exItem}" />
				</c:forEach>
			</c:if>
		</c:if>
		
		<c:if test="${!empty exhibit}">
			<c:if test="${exhibit.name != '서울역'}">
				<script>
				 	// 현재 지도의 레벨 불러오기
				    var level = map.getLevel();
				    
				    // 지도를 3레벨 낮춤 (지도가 확대됩니다)
				    map.setLevel(level - 3);
				    
				  	// 이동할 위도와 경도 위치를 생성 
				    var moveLatLon = new kakao.maps.LatLng(parseFloat("${exhibit.latClick}"), parseFloat("${exhibit.lngClick}"));
				    
				    // 지도의 중심을 부드럽게 이동
				    map.panTo(moveLatLon);
				</script>
			</c:if>
		</c:if>
		
	</section>
<wrap><%@include file="footer.html"%></wrap> 
</body>
</html>