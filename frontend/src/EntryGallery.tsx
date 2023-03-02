import {GuestbookEntry} from "./GuestbookEntry";
import EntryCard from "./EntryCard";
import AddEntry from "./AddEntry";

type EntryGalleryProps = {
    entries: GuestbookEntry[],
}

export default function EntryGallery(props: EntryGalleryProps){
    const entryCard = props.entries.map((entry) => {
        return (
            <EntryCard entry={entry} key={entry.id}/>
        );
    }).reverse();

    function handleLoginWithGitHubClick() {
        window.open("https://github.com/login/oauth/authorize?client_id=68f4dcabd39a63affbb1&scope=user", "_self");
    }

    return (
        <div>
            <button onClick={handleLoginWithGitHubClick}>Login with GitHub</button>
            <AddEntry/>
            {entryCard}
        </div>
    );
}
