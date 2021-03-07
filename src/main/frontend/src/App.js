import React, { useState, useEffect, useCallback } from "react";
import logo from "./logo.svg";
import "./App.css";
import axios from "axios";
import { useDropzone } from "react-dropzone";

const UserProfiles = () => {
	const [userProfiles, setUserProfiles] = useState([]);

	const fetchUserProfiles = () => {
		axios.get("http://localhost:8085/api/v1/user-profile").then((res) => {
			console.log(res);
			setUserProfiles(res.data);
		});
	};

	useEffect(() => {
		fetchUserProfiles();
	}, []);

	return userProfiles.map((userProfile, index) => {
		return (
			<div key={index}>
				{/* todo: profile image */}
				<br />
				<br />
				<h1>{userProfile.userName}</h1>
				<p>{userProfile.userProfileId}</p>
				<Dropzone />
				<br />
			</div>
		);
	});
};

function Dropzone() {
	const onDrop = useCallback((acceptedFiles) => {
		const file = acceptedFiles[0];
		console.log(file);
	}, []);
	const { getRootProps, getInputProps, isDragActive } = useDropzone({ onDrop });

	return (
		<div {...getRootProps()}>
			<input {...getInputProps()} />
			{isDragActive ? (
				<p>Drop the image here ...</p>
			) : (
				<p>
					Drag 'n' drop some profile images, or click to select profile image
				</p>
			)}
		</div>
	);
}

function App() {
	return (
		<div className="App">
			<UserProfiles />
		</div>
	);
}

export default App;
