import React, {useEffect, useState} from 'react';
import './App.css';
import {Route, Routes} from "react-router-dom";
import EntryGallery from "./EntryGallery";
import axios from "axios";
import {GuestbookEntry} from "./GuestbookEntry";
import GitHubRedirectPage from "./GitHubRedirectPage";

function App() {

    const [entries, setEntries] = useState<GuestbookEntry[]>([])

    useEffect(() => {
        axios.get("/api/guestbook-entries")
            .then((response) => {
                setEntries(response.data);
            })
            .catch((error) => {
                console.error(error);
            });
    }, []);

    return (
        <div className="App">
            <Routes>
                <Route path={"/"} element={<EntryGallery entries={entries}/>}/>
                <Route path={"/users/oauth/github"} element={<GitHubRedirectPage/>}/>
            </Routes>
        </div>
    );
}

export default App;
