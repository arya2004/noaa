import React, { useState } from 'react';
import axios from 'axios';

function SearchBar() {
  const [searchInput, setSearchInput] = useState('');
  const [searchResults, setSearchResults] = useState([]);

  const handleSearch = async () => {
    try {
      const response = await axios.get(`/api/problems?tag=${searchInput}`);
      setSearchResults(response.data);
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };

  return (
    <div>
      <input
        type="text"
        value={searchInput}
        onChange={(e) => setSearchInput(e.target.value)}
        placeholder="Enter a tag"
      />
      <button onClick={handleSearch}>Search</button>
      <ul>
        {searchResults.map((problem) => (
          <li key={problem.problemCode}>
            <h2>{problem.problemName}</h2>
            <p>Difficulty: {problem.difficulty}</p>
            <p>Tags: {problem.tags}</p>
            {/* ... other fields */}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default SearchBar;