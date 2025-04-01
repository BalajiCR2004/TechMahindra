import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

class MapsPage extends StatefulWidget {
  const MapsPage({super.key});

  @override
  State<MapsPage> createState() => _MapsPageState();
}

class _MapsPageState extends State<MapsPage> {
  List<dynamic> mapsData = [];
  List<dynamic> filteredMaps = [];
  bool isLoading = true;
  bool isGridView = true;
  Set<String> favoriteMaps = {}; // Stores favorite map IDs
  TextEditingController searchController = TextEditingController();

  @override
  void initState() {
    super.initState();
    fetchMaps();
  }

  Future<void> fetchMaps() async {
    const url = 'https://valorant-api.com/v1/maps';
    try {
      final response = await http.get(Uri.parse(url));
      if (response.statusCode == 200) {
        final data = json.decode(response.body);
        setState(() {
          mapsData = data['data'];
          filteredMaps = mapsData;
          isLoading = false;
        });
      } else {
        throw Exception('Failed to load maps');
      }
    } catch (e) {
      print('Error: $e');
      setState(() {
        isLoading = false;
      });
    }
  }

  void _navigateToMapDetails(BuildContext context, dynamic map) {
    Navigator.push(
      context,
      MaterialPageRoute(
        builder: (context) => MapDetailsPage(map: map),
      ),
    );
  }

  void toggleFavorite(String mapId) {
    setState(() {
      if (favoriteMaps.contains(mapId)) {
        favoriteMaps.remove(mapId);
      } else {
        favoriteMaps.add(mapId);
      }
    });
  }

  void toggleView() {
    setState(() {
      isGridView = !isGridView;
    });
  }

  void filterMaps(String query) {
    setState(() {
      if (query.isEmpty) {
        filteredMaps = mapsData;
      } else {
        filteredMaps = mapsData
            .where((map) =>
                map['displayName'].toLowerCase().contains(query.toLowerCase()))
            .toList();
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Valorant Maps')),
      body: Container(
        decoration: BoxDecoration(
          image: DecorationImage(
            image: NetworkImage('https://media.valorant-api.com/maps/2c9d57ec-4431-9c5e-2939-8f9ef6dd5cba/listviewicontall.png'),
            fit: BoxFit.cover,
          ),
        ),
        child: Column(
          children: [
            // Search Bar
           Padding(
  padding: const EdgeInsets.all(8.0),
  child: TextField(
    controller: searchController,
    onChanged: filterMaps,
    decoration: InputDecoration(
      filled: true,
      fillColor: Colors.black.withOpacity(0.5), // More transparent black
      hintText: 'Search maps...',
      hintStyle: TextStyle(color: Colors.white70), // Subtle hint color
      prefixIcon: const Icon(Icons.search, color: Colors.white),
      border: OutlineInputBorder(
        borderRadius: BorderRadius.circular(10),
        borderSide: BorderSide.none, // No border
      ),
    ),
    style: TextStyle(color: Colors.white), // White text for contrast
  ),
),

            // Toggle View Button
            Padding(
              padding: const EdgeInsets.symmetric(horizontal: 8.0),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Text(
                    isGridView ? "Grid View" : "List View",
                    style: const TextStyle(fontSize: 16, fontWeight: FontWeight.bold,color:Colors.black),
                  ),
                  IconButton(
                    icon: Icon(isGridView ? Icons.grid_on : Icons.list),
                    onPressed: toggleView,
                  ),
                ],
              ),
            ),

            // List of Maps
            Expanded(
              child: isLoading
                  ? const Center(child: CircularProgressIndicator())
                  : RefreshIndicator(
                      onRefresh: fetchMaps,
                      child: isGridView ? buildGridView() : buildListView(),
                    ),
            ),
          ],
        ),
      ),
    );
  }

Widget buildGridView() {
  return GridView.builder(
    padding: const EdgeInsets.all(8.0),
    gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
      crossAxisCount: 2,
      crossAxisSpacing: 10,
      mainAxisSpacing: 10,
    ),
    itemCount: filteredMaps.length,
    itemBuilder: (context, index) {
      final map = filteredMaps[index];
      final isFavorite = favoriteMaps.contains(map['uuid']);

      return GestureDetector(
        onTap: () => _navigateToMapDetails(context, map),
        child: Stack(
          children: [
            // Map Image as background with padding, rounded corners, and shadow
            Container(
              padding: const EdgeInsets.all(8.0), // Add space around the image
              decoration: BoxDecoration(
                borderRadius: BorderRadius.circular(20.0), // Round corners more
                boxShadow: [
                  BoxShadow(
                    color: Colors.black.withOpacity(0.5),
                    blurRadius: 8.0,
                    offset: Offset(0, 4), // Shadow position
                  ),
                ],
              ),
              child: map['splash'] != null
                  ? ClipRRect(
                      borderRadius: BorderRadius.circular(16.0), // Round corners of image
                      child: Image.network(
                        map['splash'], 
                        fit: BoxFit.cover, 
                        height: double.infinity, 
                        width: double.infinity,
                      ),
                    )
                  : const Placeholder(), // Fallback if no image
            ),
            // Text overlay
            Positioned(
              bottom: 10,
              left: 10,
              child: Text(
                map['displayName'] ?? 'Unknown',
                style: const TextStyle(
                  color: Colors.white,
                  fontWeight: FontWeight.bold,
                  fontSize: 18.0,
                  backgroundColor: Colors.black54,
                ),
              ),
            ),
            // Favorite button
            Positioned(
              top: 5,
              right: 5,
              child: IconButton(
                icon: Icon(
                  isFavorite ? Icons.favorite : Icons.favorite_border,
                  color: isFavorite ? Colors.red : Colors.white,
                ),
                onPressed: () => toggleFavorite(map['uuid']),
              ),
            ),
          ],
        ),
      );
    },
  );
}


 
  Widget buildListView() {
    return ListView.builder(
      itemCount: filteredMaps.length,
      itemBuilder: (context, index) {
        final map = filteredMaps[index];
        final isFavorite = favoriteMaps.contains(map['uuid']);

        return Card(
          color: Colors.black.withOpacity(0.85),
          child: ListTile(
            leading: Image.network(map['listViewIcon'] ?? '', width: 50),
            title: Text(map['displayName'] ?? 'Unknown', style: TextStyle(color: Colors.white)),
            trailing: IconButton(
              icon: Icon(
                isFavorite ? Icons.favorite : Icons.favorite_border,
                color: isFavorite ? Colors.red : Colors.white,
              ),
              onPressed: () => toggleFavorite(map['uuid']),
            ),
          ),
        );
      },
    );
  }
}

class MapDetailsPage extends StatelessWidget {
  final dynamic map;

  const MapDetailsPage({super.key, required this.map});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text(map['displayName'] ?? 'Unknown')),
      body: SingleChildScrollView(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            if (map['splash'] != null)
              Image.network(map['splash'], height: 300, fit: BoxFit.cover),
            const SizedBox(height: 10),
            Padding(
              padding: const EdgeInsets.all(16.0),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    "Name: ${map['displayName'] ?? 'N/A'}",
                    style: const TextStyle(fontSize: 22, fontWeight: FontWeight.bold),
                  ),
                  const SizedBox(height: 10),
                  Text(
                    "Description: ${map['tacticalDescription'] ?? 'N/A'}",
                    style: const TextStyle(fontSize: 18),
                  ),
                  const SizedBox(height: 10),
                  Text(
                    "Coordinates: ${map['coordinates'] ?? 'N/A'}",
                    style: const TextStyle(fontSize: 18),
                  ),
                  const SizedBox(height: 20),
                  if (map['listViewIcon'] != null)
                    Center(child: Image.network(map['listViewIcon'], height: 150)),
                  const SizedBox(height: 10),
                  if (map['displayIcon'] != null)
                    Center(child: Image.network(map['displayIcon'], height: 150)),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
