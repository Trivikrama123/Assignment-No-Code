import '../backend/backend.dart';
import '../flutter_flow/flutter_flow_theme.dart';
import '../flutter_flow/flutter_flow_util.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

class HomePageWidget extends StatefulWidget {
  const HomePageWidget({Key? key}) : super(key: key);

  @override
  _HomePageWidgetState createState() => _HomePageWidgetState();
}

class _HomePageWidgetState extends State<HomePageWidget> {
  final scaffoldKey = GlobalKey<ScaffoldState>();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      key: scaffoldKey,
      backgroundColor: FlutterFlowTheme.of(context).primaryBackground,
      appBar: AppBar(
        backgroundColor: Color(0xFFE9D423),
        automaticallyImplyLeading: false,
        title: Align(
          alignment: AlignmentDirectional(-0.1, 0),
          child: Text(
            'Luxury Car Collection',
            style: FlutterFlowTheme.of(context).title2.override(
                  fontFamily: 'Poppins',
                  color: FlutterFlowTheme.of(context).primaryText,
                  fontSize: 22,
                ),
          ),
        ),
        actions: [],
        centerTitle: false,
        elevation: 2,
      ),
      body: SafeArea(
        child: GestureDetector(
          onTap: () => FocusScope.of(context).unfocus(),
          child: Align(
            alignment: AlignmentDirectional(-1, -0.1),
            child: Column(
              mainAxisSize: MainAxisSize.max,
              children: [
                StreamBuilder<List<CarscollectionRecord>>(
                  stream: queryCarscollectionRecord(),
                  builder: (context, snapshot) {
                    // Customize what your widget looks like when it's loading.
                    if (!snapshot.hasData) {
                      return Center(
                        child: SizedBox(
                          width: 50,
                          height: 50,
                          child: CircularProgressIndicator(
                            color: FlutterFlowTheme.of(context).primaryColor,
                          ),
                        ),
                      );
                    }
                    List<CarscollectionRecord>
                        listViewCarscollectionRecordList = snapshot.data!;
                    return ListView.builder(
                      padding: EdgeInsets.zero,
                      shrinkWrap: true,
                      scrollDirection: Axis.vertical,
                      itemCount: listViewCarscollectionRecordList.length,
                      itemBuilder: (context, listViewIndex) {
                        final listViewCarscollectionRecord =
                            listViewCarscollectionRecordList[listViewIndex];
                        return Card(
                          clipBehavior: Clip.antiAliasWithSaveLayer,
                          color: Color(0xDEF8B188),
                          shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(10),
                          ),
                          child: Padding(
                            padding:
                                EdgeInsetsDirectional.fromSTEB(0, 10, 0, 0),
                            child: SingleChildScrollView(
                              child: Column(
                                mainAxisSize: MainAxisSize.max,
                                children: [
                                  Align(
                                    alignment: AlignmentDirectional(0, 0),
                                    child: SelectionArea(
                                        child: Text(
                                      listViewCarscollectionRecord.itemName!,
                                      style:
                                          FlutterFlowTheme.of(context).title3,
                                    )),
                                  ),
                                  Align(
                                    alignment: AlignmentDirectional(-0.75, 0),
                                    child: Image.network(
                                      listViewCarscollectionRecord.itemImg!,
                                      width: 150,
                                      height: 150,
                                      fit: BoxFit.cover,
                                    ),
                                  ),
                                  SingleChildScrollView(
                                    child: Column(
                                      mainAxisSize: MainAxisSize.max,
                                      children: [
                                        Align(
                                          alignment:
                                              AlignmentDirectional(-0.9, 0),
                                          child: SelectionArea(
                                              child: Text(
                                            listViewCarscollectionRecord
                                                .itemDesc!,
                                            style: FlutterFlowTheme.of(context)
                                                .bodyText1
                                                .override(
                                                  fontFamily: 'Montserrat',
                                                  fontSize: 14,
                                                ),
                                          )),
                                        ),
                                        Align(
                                          alignment:
                                              AlignmentDirectional(-0.9, 0.05),
                                          child: SelectionArea(
                                              child: Text(
                                            'Price:',
                                            style: FlutterFlowTheme.of(context)
                                                .bodyText1,
                                          )),
                                        ),
                                        Align(
                                          alignment:
                                              AlignmentDirectional(-0.9, 0),
                                          child: SelectionArea(
                                              child: Text(
                                            listViewCarscollectionRecord
                                                .itemPrice!
                                                .toString(),
                                            style: FlutterFlowTheme.of(context)
                                                .bodyText1,
                                          )),
                                        ),
                                      ],
                                    ),
                                  ),
                                ],
                              ),
                            ),
                          ),
                        );
                      },
                    );
                  },
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
