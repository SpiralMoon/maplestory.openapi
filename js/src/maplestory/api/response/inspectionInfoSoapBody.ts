type InspectionInfoSoapBody = {
	'soap:Envelope': {
		"$": {
			"xmlns:soap": "http://schemas.xmlsoap.org/soap/envelope/",
			"xmlns:xsi": "http://www.w3.org/2001/XMLSchema-instance",
			"xmlns:xsd": "http://www.w3.org/2001/XMLSchema"
		},
		"soap:Body": [
			{
				"GetInspectionInfoResponse": [
					{
						"$": {
							"xmlns": "https://api.maplestory.nexon.com/soap/"
						},
						"GetInspectionInfoResult": [
							{
								"xs:schema": [
									{
										"$": {
											"id": "NewDataSet",
											"xmlns": "",
											"xmlns:xs": "http://www.w3.org/2001/XMLSchema",
											"xmlns:msdata": "urn:schemas-microsoft-com:xml-msdata"
										},
										"xs:element": [
											{
												"$": {
													"name": "NewDataSet",
													"msdata:IsDataSet": "true",
													"msdata:UseCurrentLocale": "true"
												},
												"xs:complexType": [
													{
														"xs:choice": [
															{
																"$": {
																	"minOccurs": "0",
																	"maxOccurs": "unbounded"
																},
																"xs:element": [
																	{
																		"$": {
																			"name": "InspectionInfo"
																		},
																		"xs:complexType": [
																			{
																				"xs:sequence": [
																					{
																						"xs:element": [
																							{
																								"$": {
																									"name": "serviceCode",
																									"type": "xs:unsignedByte",
																									"minOccurs": "0"
																								}
																							},
																							{
																								"$": {
																									"name": "startDateTime",
																									"type": "xs:dateTime",
																									"minOccurs": "0"
																								}
																							},
																							{
																								"$": {
																									"name": "endDateTime",
																									"type": "xs:dateTime",
																									"minOccurs": "0"
																								}
																							},
																							{
																								"$": {
																									"name": "strObstacleContents",
																									"type": "xs:string",
																									"minOccurs": "0"
																								}
																							}
																						]
																					}
																				]
																			}
																		]
																	}
																]
															}
														]
													}
												]
											}
										]
									}
								],
								"diffgr:diffgram": [
									{
										"$": {
											"xmlns:msdata": "urn:schemas-microsoft-com:xml-msdata",
											"xmlns:diffgr": "urn:schemas-microsoft-com:xml-diffgram-v1"
										},
										"NewDataSet": [
											{
												"$": {
													"xmlns": ""
												},
												"InspectionInfo": [
													{
														"$": {
															"diffgr:id": "InspectionInfo1",
															"msdata:rowOrder": "0",
															"diffgr:hasChanges": "inserted"
														},
														"serviceCode": [
															string
														],
														"startDateTime": [
															string
														],
														"endDateTime": [
															string
														],
														"strObstacleContents": [
															string
														]
													}
												]
											}
										]
									}
								]
							}
						]
					}
				]
			}
		]
	}
};

export type {InspectionInfoSoapBody};
